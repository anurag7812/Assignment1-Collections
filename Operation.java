package Operation;
import java.util.*;
public class Operation{
    public static void main(String[] args) {
        List<User> list = new ArrayList<User>();
        Scanner sc_int = new Scanner(System.in);
        Scanner sc_string = new Scanner(System.in);
        int ch;
        do{
            System.out.println("1->Insert User's Data");
            System.out.println("2->Retrieve all Data");
            System.out.println("3->Retrieving a particular User ");
            System.out.println("4->deleting the User");
            System.out.println("5->Eldest among the same name");
            System.out.println("0.Exit");


            System.out.print("GIVE YOUR INPUT");
            ch = sc_int.nextInt();
            switch(ch){
                case 1:
                    System.out.print("Enter u_id : ");
                    int id = sc_int.nextInt();
                    System.out.print("Enter u_Name : ");
                    String u_name = sc_string.nextLine();
                    System.out.print("Enter u_age : ");
                    int u_age = sc_int.nextInt();
                    System.out.print("Enter password : ");
                    String u_password = sc_string.nextLine();
                    list.add(new User(id,u_name,u_age,u_password));
                    break;
                    //---------------------------------------------------------------------------------------------------
                case 2:
                    System.out.println("***********************");
                    list.forEach(a->{
                        System.out.println(a);
                    });
                    Iterator<User> i = list.iterator();
                    System.out.println("***********************");
                    break;
                    //---------------------------------------------------------------------------------------------------

                case 3:
                    boolean flag = false;
                    System.out.print("Retrieving a particular User :");
                    int u_id = sc_int.nextInt();
                    System.out.println("********************");
                    i = list.iterator();
                    while(i.hasNext()){
                        User e = i.next();
                        if(e.get_u_id() == u_id)  {
                            System.out.println(e);
                            flag = true;
                        }
                    }
                    if(!flag){
                        System.out.println("Invalid Entry - File not present");
                    }
                    System.out.println("************************");
                    break;

                    //-----------------------------------------------------------------------------------------------------
                case 4:
                    flag = false;
                    System.out.print("Enter u_id to Delete :");
                    u_id = sc_int.nextInt();
                    System.out.println("**********************");
                    i = list.iterator();
                    while(i.hasNext()){
                        User e = i.next();
                        if(e.get_u_id() == u_id)  {
                            i.remove();
                            flag = true;
                        }
                    }
                    if(!flag){
                        System.out.println("Invalid Entry");
                    }else{
                        System.out.println("Deleted Successfully...!");
                    }
                    System.out.println("*************************");
                    break;
                    //-------------------------------------------------------------------------------------------------------

                case  5:
                    System.out.println("***********************");
                    Map<String,List<User>> mp = new HashMap<>();
                    Map<String,Integer> mp1=new HashMap<>();

                    for(User p : list)
                    {
                        if(!mp.containsKey(p.get_u_name()))
                        {
                            mp.put(p.get_u_name(), new ArrayList<>());
                        }
                        mp.get(p.get_u_name()).add(p);
                    }
                    System.out.println("Total Entries --->" + mp);
                    Map<String,Integer> map=new HashMap<String,Integer>();
                    mp.forEach((k,v)->{
                        int max=0;
                        List<Integer> l=new ArrayList<>();
                        v.forEach((j)->{
                            l.add(j.get_u_age());
                        });
                        int temp=Collections.max(l);
                        map.put(k,temp);
                    });
                    System.out.println("resultant eldest:"+map);
                    System.out.println("***********************");
                    break;
                    //-----------------------------------------------------------------------------------------------------
            }
        }while(ch!=0);
    }
}
