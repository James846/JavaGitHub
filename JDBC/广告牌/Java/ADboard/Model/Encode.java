package ADboard.Model;
public class Encode {
   public static String encrypt(String sourceString,String password) { 
       char [] p= password.toCharArray();
       int n = p.length;
       char [] c = sourceString.toCharArray();
       int m = c.length; 
       for(int k=0;k<m;k++){
            int code=c[k]+p[k%n];//�򵥼���
            c[k]=(char)code;
       }
       return new String(c);    //��������
    }
}



