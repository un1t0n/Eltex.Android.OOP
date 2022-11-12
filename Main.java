/**
 * Work with classes.
 * @author Vadim Chernyavsky
 * @version v1.0
 */

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Main class.
 */
public class Main {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws IOException the io exception
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Users:");
        User myDefaultUser = new User();
        System.out.println(myDefaultUser.toStr());
        User myUser = new User(111, "Petrov", "Petr", "88005553535", "Junior Android Developer");
        System.out.println(myUser.toStr());
        System.out.println("---------------------------------------");
        System.out.println("Individual person:");
        Individual myDefaultIndividual = new Individual();
        System.out.println(myDefaultIndividual.toStr());
        Individual myIndividual = new Individual(222, "Kirillov", "Kirill", "2132131", "Cleaner");
        System.out.println(myIndividual.toStr());
        System.out.println("Company:");
        Company myDefaultCompany = new Company();
        System.out.println(myDefaultCompany.toStr());
        Company myCompany = new Company(333, "Google", "Vadimov", "Vadim", "1232113", "Logist");
        System.out.println(myCompany.toStr());
        System.out.println("---------------------------------------");
        System.out.println("Write to memory from file:");
        FileWriter fileWriter = new FileWriter("file.txt");
        fileWriter.write("121\nDanilov\nDanil\n12321312\nArchiver\n");
        fileWriter.close();
        FileReader fileReader = new FileReader("file.txt");
        Scanner scan = new Scanner(fileReader);
        int i = 0;
        while(scan.hasNextLine()) {
            switch(i) { //scan.nextLine() from every string
                case 0 : {
                    myUser.setId(Integer.parseInt(scan.nextLine()));
                    break;
                }
                case 1 : {
                    myUser.setSurname(scan.nextLine());
                    break;
                }
                case 2 : {
                    myUser.setName(scan.nextLine());
                    break;
                }
                case 3 : {
                    myUser.setPhone(scan.nextLine());
                    break;
                }
                case 4 : {
                    myUser.setJob(scan.nextLine());
                    break;
                }
            }
            i++;
        }
        System.out.println(myUser.toStr());
    }
}

/**
 * The class Env.
 */
class ENV{
    /**
     * The User id.
     */
    static int USER_ID = 1;
    /**
     * The Company id.
     */
    static int COMPANY_ID = 1;
    /**
     * The Individual id.
     */
    static int INDIVIDUAL_ID = 1;
}

/**
 * The class User.
 */
class User {
    private int id;
    private String surname;
    private String name;
    private String phone;
    private String job;

    /**
     * Instantiates a new User.
     */
    User(){
        this.id = ENV.USER_ID;
        ENV.USER_ID++;
        this.surname = "Ivanov";
        this.name = "Ivan";
        this.phone = "2000000";
        this.job = "Janitor";
    }

    /**
     * Instantiates a new User.
     *
     * @param id      the id
     * @param surname the surname
     * @param name    the name
     * @param phone   the phone
     * @param job     the job
     */
    User(int id,
         String surname,
         String name,
         String phone,
         String job){
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.phone = phone;
        this.job = job;
    }

    /**
     * To str string.
     *
     * @return the string
     */
    String toStr(){
        return id + " " + surname + " " + name + " " + phone + " " + job;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Gets surname.
     *
     * @return the surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets phone.
     *
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Gets job.
     *
     * @return the job
     */
    public String getJob() {
        return job;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Sets surname.
     *
     * @param surname the surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets phone.
     *
     * @param phone the phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Sets job.
     *
     * @param job the job
     */
    public void setJob(String job) {
        this.job = job;
    }
}

/**
 * The class Individual (person).
 */
class Individual {
    private int id;
    private String surname;
    private String name;
    private String phone;
    private String job;

    /**
     * Instantiates a new Individual.
     */
    Individual(){
        this.id = ENV.INDIVIDUAL_ID;
        ENV.INDIVIDUAL_ID++;
        this.surname = "Timofeev";
        this.name = "Timofei";
        this.phone = "2111111";
        this.job = "Cooker";
    }

    /**
     * Instantiates a new Individual.
     *
     * @param id      the id
     * @param surname the surname
     * @param name    the name
     * @param phone   the phone
     * @param job     the job
     */
    Individual(int id,
               String surname,
               String name,
               String phone,
               String job){
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.phone = phone;
        this.job = job;
    }

    /**
     * To str string.
     *
     * @return the string
     */
    String toStr(){
        return "individual person - " + surname + " " + name + " " + phone + " " + job;
    }
}

/**
 * The class Company with extends Individual.
 */
class Company extends Individual{
    private int id;
    private String companyName;
    private String surname;
    private String name;
    private String phone;
    private String job;

    /**
     * Instantiates a new Company.
     */
    Company(){
        super();
        this.id = ENV.COMPANY_ID;
        ENV.COMPANY_ID++;
        this.companyName = "Eltex";
    }

    /**
     * Instantiates a new Company.
     *
     * @param id          the id
     * @param companyName the company name
     * @param surname     the surname
     * @param name        the name
     * @param phone       the phone
     * @param job         the job
     */
    Company(int id,
            String companyName,
            String surname,
            String name,
            String phone,
            String job){
        super(id, surname, name, phone, job);
        this.id = id;
        this.companyName = companyName;
    }

    /**
     * To str string.
     *
     * @return the string.
     */
    String toStr() {
        return this.id + " " + "company - " + this.companyName + ", " + super.toStr();
    }
}