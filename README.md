https://craigs-list.herokuapp.com

Team: Sanay Oo, Philippe Rasay Guerrero, Bartek Gembala

supports:  /address   /address/{ID}   /person   /person/{ID}  /person/{firstname}  /person/{lastname} 


relatives not quite working, managin to insert to relationtable, but not getting newly added data out
missing update and delete as well

JSON format:

{
    "firstName": "Sooon",
    "lastName": "SOOOaN",
    "birth": "1993",
    "address": "Vietnam",
    "relatives": [
    	{
    		"toPersonID": "1",
    		"relation": "Brother"
    	}
    ],
    "personalMail": "test1",
    "workMail": "test2",
    "contact" : {
    	"work": "22",
    	"home": "33",
    	"mobile": "44"
    }
}
