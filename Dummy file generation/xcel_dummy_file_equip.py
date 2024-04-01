import math
import random
import xlsxwriter
import csv
#changed to output .csv
equipment_id_list = {'HMB':[350,'Ball-peen Hammer', '16 OZ'],
                     'SI':[500,'Soldering Iron','120V 70W'],
                     'MTM':[650,'Multimeter','Fluke'],
                     'APM':[650,'Ammeter','Fluke Clamp'],
                     'PWB':[650,'Power Supply','Benchtop'],
                     'PWW':[350,'Power Supply','5V Wall Wart'],
                     'OSC':[550,'Oscilloscope','2 Port'],
                     'TPK':[600,'Test Probe','Kit - 25pc'],
                     'TPS':[800,'Test Probe','Single'],
                     'LAS':[600,'Logic Analyzer','Small Circuit'],
                     'LAL':[850,'Logic Analyzer','Large Circuit'],
                     'TL12':[550,'Test Light','12V'],
                     'TL5':[450,'Test Light','5V'],
                     'TL3':[450,'Test Light','3V'],
                     'CTL':[750,'Continuity Tester','Low Current']}
status_list = {'Checked Out':['Out'],
               'Available':['Primary','Secondary']}

equipmentList = []
equipmentcsv=[]
employeeIdSet = set()
employeeCountNeeded = 8500
employeeCount = 0
numberTries=4
#workbook = xlsxwriter.Workbook(f'EquipmentListTest{numberTries}.xlsx')
#worksheet = workbook.add_worksheet('Equipment')

row = 0
col = 0

class EquipmentTable:
    def __init__(self, EquipmentIDChar, EquipmentIDNum, EquipmentName, Description, Status, Location):
        self.EquipmentIDChar = EquipmentIDChar
        self.EquipmentIDNum = EquipmentIDNum
        self.EquipmentName = EquipmentName
        self.Description = Description
        self.Status = Status
        self.Location = Location
        
    def __str__(self):
        return f"{self.EquipmentIDChar},{self.EquipmentIDNum},{self.EquipmentName},{self.Description},{self.Status},{self.Location}"

def getStatus():
    coinToss = random.randint(0,50)
    if coinToss %2 == 0:
        return 'Checked Out'
    else:
        return 'Available'
    

def getLocation(currentStatus):
    coinToss = random.randint(0,50)
    if currentStatus == 'Checked Out':
        return 'Out'
    elif coinToss %2 == 0 and currentStatus == 'Available':
        return 'Primary'
    else:
        return 'Secondary'
"""
bold = workbook.add_format({'bold':True})
worksheet.write(row, col, 'EquipmentIDChar', bold)
worksheet.write(row, col+1, 'EquipmentIDNum', bold)
worksheet.write(row, col+2, 'EQUIPMENTNAME', bold)
worksheet.write(row, col+3, 'DESCRIPTION', bold)
worksheet.write(row, col+4, 'STATUS', bold)
worksheet.write(row, col+5, 'LOCATON', bold)
row+=1
"""
equipmentcsv.append(['EqupmentIDChar','EquipmentIDNum','EquipmentName','Description','Status','Location'])
for key in equipment_id_list:
    idnumber=1
    while idnumber<=equipment_id_list[key][0]:
        fullId=[]
        status =  getStatus()
        fullId.append(key)
        fullId.append('{:03d}'.format(idnumber))       
        equip = EquipmentTable(key, idnumber, equipment_id_list[key][1],  equipment_id_list[key][2], status, getLocation(status))
        equipmentList.append(equip)
        idnumber+=1
        equipmentcsv.append([key, '{:03d}'.format(idnumber), equipment_id_list[key][1],  equipment_id_list[key][2], status, getLocation(status)])
        #strEquip = [x for x in str(equip).split('|')]
        #for item in strEquip:
        #    worksheet.write(row, col, item)
        #    col +=1
        #col=0
        #row+=1

with open(f'EquipmentListTest{numberTries}.csv', 'w') as csvFile:
    csvwriter = csv.writer(csvFile)
    csvwriter.writerows(equipmentcsv)



#print(employeeList)
#for _ in employeeList:
    #print(_)
#    print(str(_))
csvFile.close()
#workbook.close()