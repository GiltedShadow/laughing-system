from datetime import datetime as dt
import numpy
import time as t
import math

def calcPi2(x):
     
    # Initialize denominator
    k = 1
    start = dt.now()
    # Initialize sum
    s = 0
 
    for i in range(x):
 
    # even index elements are positive
        if i % 2 == 0:
            s += 4/k
        else:
            # odd index elements are negative
            s -= 4/k
 
        # denominator is odd
        k += 2
    end = dt.now()
    final = end-start
    print(s)
    print(f"time taken: {final}")
    print(comparePi(s))


def calcPi(x):
         
    # Initialize denominator
    k = 1
    start = t.time()
    # Initialize sum
    s = 0
 
    for i in range(x):
 
    # even index elements are positive
        if i % 2 == 0:
            s += 4/k
        else:
            # odd index elements are negative
            s -= 4/k
 
        # denominator is odd
        k += 2
    end = t.time()
    final = end-start
    print(s)
    print(f"time taken: {final}")
    print(comparePi(s))


def comparePi(x):
    listOne = list(format(x, '.50f'))
    listTwo = [_ for _ in format(math.pi, '.50f')]
    accurate = -2
    #print(listOne)
    #print(listTwo)
    for num in range(52):
        if listOne[num]==listTwo[num]:
            accurate+=1
        
        else:
            if accurate%10==1:
                return f"This number is accurate to the {accurate}st digit"
            elif accurate%10==2:
                return f"This number is accurate to the {accurate}nd digit"
            elif accurate%10==3:
                return f"This number is accurate to the {accurate}st digit"
            else:
                return f"This number is accurate to the {accurate}th digit"
