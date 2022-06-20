class Database {
    private static Database dbObject;

    private Database() {
    }

    public static Database getInstance() {

        // create object if it's not already created
        if(dbObject == null) {
            dbObject = new Database();
        }

        // returns the singleton object
        return dbObject;
    }

    public void getConnection() {
        System.out.println("You are now connected to the database.");
    }
}

public class Singleton {
    public static void main(String[] args) {
        Database db1;
        // Database db2 = new Database();   (can't create a new object directly)

        // refers to the only object of Database
        db1= Database.getInstance();

        db1.getConnection();
    }
}
