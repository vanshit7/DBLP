package entity;

import java.util.*;

public class Entity_Resolution {
	String str1="s. k. m. p.";
	String str2="s.";
	ArrayList<String> array1=new ArrayList<String>(Arrays.asList(str1.split(" ")));   
	ArrayList<String> array2=new ArrayList<String>(Arrays.asList(str2.split(" ")));
	int len1= array1.size();
	int len2=array2.size();
	char fsfn = array1.get(0).charAt(0);  //fsfn=first string fist name
	char fsln = array1.get(len1-1).charAt(0);
	char ssfn = array2.get(0).charAt(0);  //ssfn=second string fist name
	char ssln = array2.get(len2-1).charAt(0);
	public int check(){
		if(len1==1 || len2==1)
		{
			return condition(0,0);
		}
		if(first()==0)
		{
			return 0;
		}
		else
		{
			/*if(second()==1)
				return 1;*/
		 return 0;
		}
	}
	public int condition(int pos1,int pos2)
	{
			if((array1.get(pos1).charAt(0))==((array2.get(pos2).charAt(0))))
			{
				if(array1.get(pos1).equals(array2.get(pos2)))
					{
					return 1;
					}
				else
				{
					if((array1.get(pos1).charAt(1)=='.' || array2.get(pos2).charAt(1)=='.')&& ((array1.get(pos1).length()!=1) && array2.get(pos2).length()!=1 ))
						return 1;
					else return 0;
				}
			}
			else
			{
				return 0;
		    }
		
	}
	public int first(){
		
		if(array1.get(0).equals(array2.get(0)))
		{
			return condition(len1-1,len2-1);
		}
		else 
		{
			int res=condition(0,0);
			if(res==1)
				return condition(len1-1,len2-1);
			else return 0;
		}
	}
	

	public static void main(String[] args){
		Entity_Resolution e=new Entity_Resolution();
		//e.print();
		int ans=e.check();
		System.out.println(ans);
	}
	
	
	
}
