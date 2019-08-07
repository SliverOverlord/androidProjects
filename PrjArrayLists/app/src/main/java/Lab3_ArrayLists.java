
import java.util.*;

public class Lab3_ArrayLists {
    public static void main(String args[]) {
        ArrayList scList = new ArrayList();
        ArrayList nameList = new ArrayList();

        String tmpName;
        System.out.println("Number of elements: " + scList.size());

        //add stuff
        scList.add(90);
        scList.add(100);
        scList.add(67);
        scList.add(83);
        scList.add(79);
        scList.add(56);
        scList.add(1, 99);

        System.out.println("Size after insertions:" + scList.size());
        System.out.println("scList: " + scList);

        //find 83
        int pos = scList.indexOf(83);

        System.out.println("Position of 83: " + Integer.valueOf(pos));
        //find 88 not here
        pos = scList.indexOf(88);

        System.out.println("Position of 88: " + Integer.valueOf(pos));
        scList.remove(2);

        scList.remove(new Integer(79));
        System.out.println("Size after deletions: " + scList.size());
        System.out.println("scList: " + scList);
        boolean errFlag = false;
        try {
            scList.remove(110);
        }
        catch (IndexOutOfBoundsException e) {
            errFlag = true;
        }
        if (errFlag){ System.out.println("Cannot remove "
        + Integer.valueOf(110) + " Position is off end of array ");}


        Scanner input = new Scanner(System.in);
        //System.out.println(input.nextLine());
        System.out.println("Enter students first and last name or DONE to exit: ");

        tmpName = input.nextLine();
        while (tmpName != "DONE") {
            nameList.add(tmpName);
            System.out.println("Enter students first and last name or DONE to exit: ");
            tmpName = input.nextLine();
            if (tmpName.equals("DONE"))
                break;

        }
        System.out.println("Number of elements: " + nameList.size());
        System.out.println(nameList);

        System.out.println("Enter a name to delete: ");
        tmpName = input.nextLine();
        boolean errFlag2 = false;

        try {
            int pos2 = nameList.indexOf(tmpName);
            nameList.remove(pos2);
            //for (int i =0; i < nameList.size(); i++) {
                //if (nameList.get(i)==tmpName) {
                    //nameList.remove(i);
            System.out.println("Name removed from list.");
            System.out.println("Number of elements: " + nameList.size());
            System.out.println(nameList);
                //}
            //}
        }
        catch (IndexOutOfBoundsException e) {
            errFlag2 = true;
        }
        if (errFlag2){ System.out.println("Cannot remove "
                + tmpName + " is not in the array ");}



        //System.out.println(nameList);
        nameList.add(0,"Joe Smith");
        Collections.sort(nameList);
        System.out.println(nameList);
    }

        //tmpName =input("Enter a name or Done to finish");



    }
