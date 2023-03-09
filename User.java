package Operation;

public class User{
    private int u_id;
    private String u_name;
    private int u_age;
    private String u_password;

    User(int u_id, String u_name, int u_age,String u_password){
        this.u_id = u_id;
        this.u_name = u_name;
        this.u_age = u_age;
        this.u_password=u_password;
    }

    public int get_u_id(){
        return u_id;
    }
    public int get_u_age(){
        return u_age;
    }
    public String get_u_name(){
        return u_name;
    }

    public String toString(){
        return u_id+" "+u_name+" "+u_age+" "+u_password;
    }
}
