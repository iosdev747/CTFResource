import java.io.*;
import java.util.HashMap; 
import java.util.Map;

class Safe implements java.io.Serializable 
{ 
	public long arr[] = new long[10];
	
	Safe(){
		arr[0]=1111111111l;
		arr[1]=1111111111l;
		arr[2]=1111111111l;
		arr[3]=1111111111l;
		arr[4]=1168886888l;
		arr[5]=1111111111l;
		arr[6]=1111111111l;
		arr[7]=1111111111l;
		arr[8]=1111111111l;
		arr[9]=1111111111l;
	}
} 

class Vault 
{ 
	public static void main(String[] args) 
	{ 
		Safe object = new Safe();
		String filename = "file.ser";
		try
		{ 
			FileOutputStream file = new FileOutputStream(filename); 
			ObjectOutputStream out = new ObjectOutputStream(file); 
			out.writeObject(object); 
			out.close(); 
			file.close(); 
			System.out.println("Object has been serialized"); 
		} 
		catch(IOException ex) 
		{ 
			System.out.println("IOException is caught"); 
		} 

		Safe object1 = null; 
		try
		{
			FileInputStream file = new FileInputStream(filename); 
			ObjectInputStream in = new ObjectInputStream(file); 
			object1 = (Safe)in.readObject(); 
			in.close(); 
			file.close(); 
			System.out.println("Object has been deserialized "); 
			System.out.println(object1.arr);
			System.out.println(object1.arr[4]);
			System.out.println(object1.arr[5]);
		} 
		catch(IOException ex) 
		{ 
			System.out.println("IOException is caught"); 
		} 
		
		catch(ClassNotFoundException ex) 
		{ 
			System.out.println("ClassNotFoundException is caught"); 
		} 

	} 
} 
