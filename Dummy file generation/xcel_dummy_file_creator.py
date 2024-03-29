import math
import random
import xlsxwriter

firstNames = ['James','Mary','Robert','Patricia','John','Jennifer','Michael',
              'Linda','David','Elizabeth','William','Barbara','Richard',
              'Susan','Joseph','Jessica','Thomas','Sarah','Christopher',
              'Karen','Charles','Karen','Daniel','Nancy','Matthew','Betty',
              'Anthony','Sandra','Mark','Margaret','Donald','Ashley','Steven',
              'Kimberly','Andrew','Emily','Paul','Donna','Joshua','Michelle',
              'Kenneth','Carol','Kevin','Amanda','Brian','Melissa','George',
              'Deborah','Timothy','Stephanie','Ronald','Dorothy','Jason',
              'Rebecca','Edward','Sharon','Jeffery','Laura','Ryan','Cynthia',
              'Jacob','Amy','Gary','Kathleen','Nicholas','Angela','Eric',
              'Shirley','Jonathan','Brenda','Stephan','Emma','Larry','Anna',
              'Justin','Pamela','Scott','Nicole','Brandon','Samantha','Benjamin',
              'Katherine','Samuel','Christine','Gregory','Helen','Alexander',
              'Debra','Patrick','Rachel','Frank','Carolyn','Raymond','Janet',
              'Jack','Maria','Dennis','Catherine','Jerry','Heather']
lastNames = ['A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P',
             'Q','R','S','T','U','V','W','X','Y','Z']
passwordPull = ['1','2','3','4','5','6','7','8','9','0','a','b','c','d','e',
                'f','g','h','i','j','k','l','m','n','o','p','q','r','s','t',
                'u','v','w','x','y','z','.',',','/','?','<','>',';',':',"'",
                '"','[',']','{','}','\\','|','!','@','#','$','%','^','&','*',
                '(',')','_','-','+','A','B','C','D','E','F','G','H','I',
                'J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X',
                'Y','Z']
role = ['Admin','Managment','Technician','Maintenance','Warehouse']
endorcement = {'Admin':[''],
               'Managment':['Staff','Maintenance','Warehouse','Technician'],
               'Maintenance':['Electrician','Machine','Painter','Welder',
                              'Plumber','Carpenter','None'],
               'Technician':[''],
               'Warehouse':['Inventory','Equipment']}

employeeList = []
employeeIdSet = set()
employeeCountNeeded = 8500
employeeCount = 0
maintWorkerCount = 0
maintRemoved = False
numberTries=8
workbook = xlsxwriter.Workbook(f'UserAuthTest{numberTries}.xlsx')
worksheet = workbook.add_worksheet('UserAuthList')

row = 0
col = 0

class UserAuth:
    def __init__(self, UserID, UserName, Password, Role, Endorsement='', employeeCountNeeded = 1000):
        self.UserID = UserID
        self.UserName = UserName
        self.Password = Password
        self.Role = Role
        self.Endorsement = Endorsement
        #self.employeeCount = 0
        #self.employeeIdSet = {}
        #self.employeeList = []
        
    def __str__(self):
        return f"{self.UserID} {self.UserName} {self.Password} {self.Role} {self.Endorsement}"
    
    def __int__(self):
        return int(self.UserID)
    
    def __len__(self):
        return self.employeeCount

def getUserID():
    idNumber = []
    for _ in range(9):
        idNumber.append(str(random.randint(0, 9)))
    if idNumber[0] == 0:
        idNumber[0] = 1
    userid = ''.join(idNumber)
    if userid not in employeeIdSet:
        employeeIdSet.add(userid)
        return userid
    
def getUserName():
    fName = firstNames[random.randint(0, len(firstNames)-1)]
    lName = lastNames[random.randint(0, len(lastNames)-1)]
    return f"{fName}{lName}"

def getPassword():
    passList = []
    passwd = ''
    for _ in range(0, random.randint(8, 12)):
        passList.append(str(passwordPull[random.randint(0, len(passwordPull)-1)]))
    passwd = ''.join(passList)
    return passwd

def getRole():
    return role[random.randint(0, len(role)-1)]

def getEndorcement(providedRole):
    global maintWorkerCount
    global maintRemoved
    if providedRole == 'Admin' or providedRole == 'Technician':
        return 'None' 
    elif providedRole == 'Maintenance':
        maintWorkerCount += 1
    if maintWorkerCount == 300 and maintRemoved == False:
        role.pop(3)
        maintRemoved = True
    #print(endorcement[providedRole])
    maxNum = len(endorcement[providedRole])-1
    return endorcement[providedRole][random.randint(0, maxNum)]
bold = workbook.add_format({'bold':True})
worksheet.write(row, col, 'USERID', bold)
worksheet.write(row, col+1, 'USERNAME', bold)
worksheet.write(row, col+2, 'PASSWORD', bold)
worksheet.write(row, col+3, 'ROLE', bold)
worksheet.write(row, col+4, 'END', bold)
row+=1

while employeeCount < employeeCountNeeded:
    thisRole = getRole()
    user = UserAuth(getUserID(), getUserName(), getPassword(), thisRole, getEndorcement(thisRole))
    employeeList.append(user)
    strUser = [x for x in str(user).split(' ')]
    for item in strUser:
        if col == 0:
            worksheet.write(row, col, int(item))
        else:
            worksheet.write(row, col, item)
        col +=1
    row += 1
    col = 0
    employeeCount += 1

#print(employeeList)
#for _ in employeeList:
    #print(_)
#    print(str(_))

workbook.close()