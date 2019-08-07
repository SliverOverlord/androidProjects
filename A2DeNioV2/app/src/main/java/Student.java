public class Student {
    private String firstName;
    private String lastName;
    private int test1,test2,test3;
    private int id;
    private static int lastId;

    public Student(String firstName, String lastName, int test1, int test2, int test3) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.test1 = test1;
        this.test2 = test2;
        this.test3 = test3;
        this.id = ++lastId;
        //newId = newId++;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getTest1() {
        return test1;
    }

    public int getTest2() {
        return test2;
    }

    public int getTest3() {
        return test3;
    }

    public int getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTest1(int test1) {
        this.test1 = test1;
    }

    public void setTest2(int test2) {
        this.test2 = test2;
    }

    public void setTest3(int test3) {
        this.test3 = test3;
    }

    public String toString(){
        return firstName + " " + lastName + " Test1: " + getTest1()+ " Test2: "+getTest2()+
                " Test3: "+getTest3();
    }
}

