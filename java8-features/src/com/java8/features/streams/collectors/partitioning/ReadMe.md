Persons Collection: [
Person [id=1, name=Ken, gender=MALE, dob=1982-07-10, income=6000.0], 
Person [id=1, name=ben, gender=MALE, dob=1980-08-20, income=2000.0], 
Person [id=1, name=sen, gender=FEMALE, dob=1986-07-15, income=5000.0], 
Person [id=1, name=pen, gender=MALE, dob=1981-01-05, income=7000.0], 
Person [id=1, name=fen, gender=FEMALE, dob=1984-09-22, income=6300.0]]


#Collectors.partitioningBy(Predicate<? super T> predicate)
#Partitioning persons by male gender.

PartitioningPersonsByMale: 
	{false=[
			Person [id=1, name=sen, gender=FEMALE, dob=1986-07-15, income=5000.0], 
			Person [id=1, name=fen, gender=FEMALE, dob=1984-09-22, income=6300.0]], 
	true=[
			Person [id=1, name=Ken, gender=MALE, dob=1982-07-10, income=6000.0], 
			Person [id=1, name=ben, gender=MALE, dob=1980-08-20, income=2000.0], 
			Person [id=1, name=pen, gender=MALE, dob=1981-01-05, income=7000.0]]
	}


#Collectors.partitioningBy(Predicate<? super T> predicate, Collector<? super T,A,D> downstream)
#Partitioning person names by male gender.

PartitioningPersonNamesByMaleGender: {false=sen, fen, true=Ken, ben, pen}
