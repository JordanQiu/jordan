package com.jordan;

import java.util.List;

import com.jordan.controller.UserController;
import com.jordan.domain.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       UserController usercon = new UserController();
      
//       List<User> userlist = usercon.findUser();
//       for(int i=0;i<userlist.size();i++){
//    	   User t = userlist.get(i);
//    	   Syst em.out.println(t.getName());
//       }
       
       
       User user = new User();
       user.setAge(2);
       user.setId(22);
       user.setName("2222222");
       user.setPol_code("446662");
       usercon.saveUser(user);
       
//       int id =1;
//       usercon.deleteUser(id);
       
       
//        User user = new User();
//      
//        for(int id = 1;id<23;id++){
//        	
//        user.setId(id);
//        user.setName("Jordan" + id);
//        user.setAge(23 + id);
//        String[] pol_code= {"489","442","443","478"};
//        for(String code:pol_code){
//        user.setPol_code(code);
//        break;
//        }
//        usercon.editUser(user,id);
//        } 
       
       
       
       
       
    }
 
}
