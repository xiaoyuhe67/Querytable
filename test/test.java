import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import DBUtility.DBUtility;

public class test {

	@Test
	public void test() throws SQLException {
		List<String> mylist = new ArrayList<String>();
		mylist=DBUtility.select("select firstname, lastname, streetaddress from customers");
		String content="";
		int i=1;
		for(String d:mylist) {	
            
            if((i%3)==0)
            {
            	content+=d+" "+"\n";
            }
            else
            {
            	content+=d+" ";
            }
            if(i==10*3)
            {
            	break;
            }
            i++;
            
        }
		System.out.println(content);
	}

}
