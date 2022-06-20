import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

// user
class User {
    private String name;
    private String email;

    // constructors / standard setters / getters


    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}

// interface
interface Dao<T> {
    Optional<T> get(long id);

    List<T> getAll();

    void save(T t);

    void update(T t, String[] params);

    void delete(T t);
}

// dao
class UserDao implements Dao<User> {

    private List<User> users = new ArrayList<>();

    public UserDao() {
        users.add(new User("John", "john@domain.com"));
        users.add(new User("Susan", "susan@domain.com"));
    }

    @Override
    public Optional<User> get(long id) {
        return Optional.ofNullable(users.get((int) id));
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public void update(User user, String[] params) {
        user.setName(Objects.requireNonNull(
                params[0], "Name cannot be null"));
        user.setEmail(Objects.requireNonNull(
                params[1], "Email cannot be null"));
        // users.add(user);
    }

    @Override
    public void delete(User user) {
        users.remove(user);
    }
}

// driver
public class DAO_Example {
    private static Dao<User> userDao;

    public static void main(String[] args) {
        userDao = new UserDao();

        // print current users
        System.out.println("users : "+userDao.getAll());

        // update
        User user1 = getUser(0);
        userDao.update(user1, new String[]{"Jake", "jake@domain.com"});
        System.out.println("after update : "+userDao.getAll());

        // delete
        User user2 = getUser(1);
        userDao.delete(user2);
        System.out.println("after delete : "+userDao.getAll());

        // add
        userDao.save(new User("Julie", "julie@domain.com"));
        System.out.println("after adding a new user : "+userDao.getAll());

        userDao.getAll().forEach(user -> System.out.println(user.getName()));
    }

    private static User getUser(long id) {
        Optional<User> user = userDao.get(id);
        return user.orElseGet(
                () -> new User("non-existing user", "no-email"));
    }
}
