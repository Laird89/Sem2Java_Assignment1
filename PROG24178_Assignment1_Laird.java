/* Name: Chris Laird
* Class: PROG24178 1231_18326, Winter 2023
* Assignment: Assignment #1 – Displaying Information
* Date: January 25, 2023
* Program: PROG24178_Assignment1_Laird.java
* Creating 4 different methods
* one to check the number of friends are in an array
* one to add a friend to that array
* one to remove of friend from that array
* and one to print an array of strings of the names of the friends
*/


import java.util.*;

/**
 * Requirements:
 * 1. Replace LastName in file and class names with your own name.
 * 2. Finish all TODOs. Test your code before submitting it.
 * 3. Do NOT modify ANY provided code.
 */
public class PROG24178_Assignment1_Laird{
    public static void main(String[] args) {
        int pass = 0, total = 15;
        Person spiderman = new Person("Spiderman", 18);
         if (spiderman.getNumOfFriends() == 0
                && !spiderman.removeFriend(null)
                && !spiderman.removeFriend("Spiderman")
                && spiderman.getAllFriendNames() == null) System.out.println("Pass #1: " + (++pass));
        if (!spiderman.addFriend(null)
                && !spiderman.addFriend(new Person(null, 23))) System.out.println("Pass #2: " + (++pass));
        if (spiderman.addFriend(new Person("MJ", 18))
                && spiderman.addFriend(new Person("Ned", 18))
                && spiderman.addFriend(new Person("Hulk", 27))) System.out.println("Pass #3: " + (++pass));
        if (spiderman.getNumOfFriends() == 3
                && spiderman.getAllFriendNames().length == 3) System.out.println("Pass #4: " + (++pass));
        if (spiderman.getAllFriendNames()[0].equals("MJ")
                && spiderman.getAllFriendNames()[1].equals("Ned")
                && spiderman.getAllFriendNames()[2].equals("Hulk")) System.out.println("Pass #5: " + (++pass));
        if (!spiderman.removeFriend("Thanos")
                && spiderman.removeFriend("Ned")
                && !spiderman.removeFriend("Ned")) System.out.println("Pass #6: " + (++pass));
        if (spiderman.getNumOfFriends() == 2
                && spiderman.getAllFriendNames().length == 2) System.out.println("Pass #7: " + (++pass));
        if (!spiderman.addFriend(new Person("Hulk", 27))) System.out.println("Pass #8: " + (++pass));
        if (spiderman.addFriend(new Person("Thor", 28))
                && spiderman.addFriend(new Person("Ironman", 35))
                && spiderman.addFriend(new Person("Dr. Strange", 32))) System.out.println("Pass #9: " + (++pass));
        if (spiderman.getNumOfFriends() == 5
                && spiderman.getAllFriendNames().length == 5) System.out.println("Pass #10: " + (++pass));
        if (!spiderman.addFriend(new Person("Superman", 33))) System.out.println("Pass #11: " + (++pass));
        if (spiderman.removeFriend("Thor")
                && spiderman.removeFriend("Ironman")) System.out.println("Pass #12: " + (++pass));
        if (spiderman.getNumOfFriends() == 3
                && spiderman.getAllFriendNames().length == 3) System.out.println("Pass #13: " + (++pass));
        if (spiderman.removeFriend("Hulk")
                && spiderman.removeFriend("MJ")
                && !spiderman.removeFriend("Hulk")) System.out.println("Pass #14: " + (++pass));
        if (spiderman.getNumOfFriends() == 1
                && spiderman.getAllFriendNames().length == 1
                && spiderman.getAllFriendNames()[0].equals("Dr. Strange")) System.out.println("Pass #15: " + (++pass));
        System.out.println("\nPass/Total = " + pass + "/" + total);
        System.out.println(spiderman);
    }
}

class Person {
    private String name;
    private int age;
    private Person[] friends;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        friends = new Person[5]; //assume maximum 5 possible friends
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person[] getFriends() {
        return friends;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' +
                ", age=" + age + ", friends=" + Arrays.toString(friends) + '}';
    }

    /* ==== Do NOT modify any code above this line ==== */

    /**
     * TODO #1 - write a public method named getNumOfFriends that
     * - accepts no argument
     * - return the number of friends of this person (can be 0-5)
     */
    public int getNumOfFriends(){
		
		//check to see if friends array is null or the array length is 0
		//if it meets either of those it will return 0
		if (friends == null)
			return 0;
		
		int counter = 0; //create counter variable with a value of 0
		
		//for loop going through each friend array index and if the value
		//in that index isn't null then it adds to the counter
		for (int i = 0; i < friends.length; i++){
			
			if (friends[i] != null)
				counter++;
			
		}
		
		return counter; //returns the counter
		
	}
	
	

    /**
     * TODO #2 - write a public method named addFriend that
     * - accepts a person as the argument
     * - adds this person to the friends array
     * - returns true if the person is added successfully, otherwise returns false
     * - Note: a person can be added as a friend only when it is a valid person with a valid name
     * - Note: return false if the person is already a friend or the friend array is full
     */
	 
	 public boolean addFriend(Person friendAdded){
		
		//check to see if friends array is null or 
		//if the number of friends is equal to the 
		//length of the number of friends person has
		//or if the value of friendAdded is null
		//or if the friend added names is null
		//if any are then it will return false
		if(friends == null || getNumOfFriends() == getFriends().length || friendAdded == null || friendAdded.getName() == null)
			return false;


		// enter a for loop and check to see if
		// friends at the index is not null and
		// if the friend added name is equal to the name at friends index i
		//if it is than it will return false
		for (int i = 0; i < friends.length; i++){
			
			if(friends[i] != null && friendAdded.getName().equals(friends[i].getName()))
				return false;
				
		}
		
		// for loop checking if the friend at index i is null
		// if so a friend will be added to that index and return true
		for (int i = 0; i < friends.length; i++){	
		
			if(friends[i] == null) {
				friends[i] = friendAdded;
                return true;
            }
			
		}
		
        return false;
		
	 }


    /**
     * TODO #3 - write a public method named removeFriend that
     * - accepts a string as the argument
     * - removes the friend of the specified name from the friends array
     * - returns true if the friend is successfully removed, otherwise returns false
     */
	 
    public boolean removeFriend(String delFriend){

        // checking to see if the friends array is null
        // or the delFriend String is null
		// or if the number of friends is 0
        // if it meets any condition it will return false
        if(friends == null || delFriend == null || getNumOfFriends() == 0)
            return false;
		
        boolean check = false; // creating a boolean variable check
		
		// for each loop checking if the friend being removed
		// is already in the friends names array
		// if condition is met check variable becomes true
        for (String s : getAllFriendNames()) { 
		
            if (delFriend.equals(s)) { 
                check = true;
				
            } 
        }

		// if the check variable is false after the loop it will return false
        if(!check) {
            return check;
        }

        // goes into for loop, friends at the index is not null
        // and friends name at that index is not null
        // and friends name at that index is equal to delFriend
        // if all conditions are met 
        // if it meets all conditions it will remove the friend at that index
        for(int i = 0; i < friends.length; i++){

            if(friends[i] != null && friends[i].getName() != null 
			&& friends[i].getName().equals(delFriend)){
				
                friends[i] = null;
					
					//enters second for loop that will shift the friends
					//spot in the array once removed
                    for(int j = i; j < friends.length - 1; j++){
    
                        friends[j] = friends[j + 1];
						
                        friends[j + 1] = null;
    
                    }
					
                return true;
                
            }
        }

        return true;

        }


    /**
     * TODO #4 - write a public method named getAllFriendNames that
     * - accepts no argument
     * - returns an array of strings containing all friends' names, or returns null if no name to return
     * - Note: the length of the returned array must be exactly the same as the number of friend names
     */


	public String[] getAllFriendNames(){
		
		// check to see if friends array is null or number of friends is 0
		// if conditions are met it returns null
		if (friends == null || getNumOfFriends() == 0)
			return null;
		
		// creating an int variable count to count the amount of 
		// friends to create an array of that length
		int count = 0;
		
		// for loop checking if friends at index i is not null and 
		// the friends name at that index is not null
		// if conditions are met it adds to the count
		for (int i = 0; i < friends.length; i++){
		
			if (friends[i] != null && friends[i].getName() != null)
				count++;
			
		}
		
		String[] list = new String[count]; // create a String array thats the length of the count
		
		// for loop checking if friends name at index i isnt null 
		// and the friends index at i isnt null
		// if conditions are met it adds the friends name from
		// index i to String array list at index i
		for (int i = 0; i < friends.length; i++){
			
			if (friends[i] != null && friends[i].getName() != null )
				list[i] = friends[i].getName();
			
		}
		
		return list; //returns String array list
		
	}


} //End of Person class