Persons Collection: [
Person [id=1, name=Ken, gender=MALE, dob=1982-07-10, income=6000.0], 
Person [id=1, name=ben, gender=MALE, dob=1980-08-20, income=2000.0], 
Person [id=1, name=sen, gender=FEMALE, dob=1986-07-15, income=5000.0], 
Person [id=1, name=pen, gender=MALE, dob=1981-01-05, income=7000.0], 
Person [id=1, name=fen, gender=FEMALE, dob=1984-09-22, income=6300.0]]


#Collectors.collectingAndThen
#Obtain a collection of person names 
#and then convert it to unmodifiable collection before returning the result.


Person Names: [Ken, ben, sen, pen, fen]


# We need a map of months with names whose have birthdays in that month.
# 1) All the names of the months irrespective of any person has birthday in that month.
# 2) Months in sorted order. 
# 3) Result in immutable form.

MARCH=None
JULY=Ken, sen
OCTOBER=None
MAY=None
APRIL=None
DECEMBER=None
SEPTEMBER=fen
AUGUST=ben
FEBRUARY=None
JANUARY=pen
JUNE=None
NOVEMBER=None


