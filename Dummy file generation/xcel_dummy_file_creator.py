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
                '(',')','_','-','=','+','A','B','C','D','E','F','G','H','I',
                'J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X',
                'Y','Z']
role = ['Admin','Managment','Technician','Maintenance','Employee','Warehouse'],
endorcement = {'Management':['Staff','Maintenance','Warehouse','Technician'],
               'Maintenance':['Electrician','Machine','Painter','Welder',
                              'Plumber','Carpenter'],
               'Technician':[],
               'Warehouse':['Inventory','Equipment']}
