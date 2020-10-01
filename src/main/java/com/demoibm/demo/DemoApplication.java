package com.demoibm.demo; 

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws RuntimeException, InterruptedException {
		SpringApplication.run(DemoApplication.class, args);
		
        String fileName = "file.csv";
        File file = new File(fileName);
        
        String line = "";
        String cvsSplitBy = ";";
        String[] receita = new String [1];
        
        
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            while ((line = br.readLine()) != null) {
                // use comma as separator
                 receita = line.split(cvsSplitBy);            
            }
            
             ReceitaService receitaService = new ReceitaService(); 
             String conta = removeChar(receita[1],'-');
             conta = conta.trim();
             System.out.println(conta.length());
             double saldo = Double.parseDouble(receita[2]);                
             String resposta = "" + receitaService.atualizarConta(receita[0], conta, saldo, receita[3]);   
             System.out.println(resposta);
             receita = add(receita, resposta);
             
             System.out.println(receita);
             
             //Escrever agora o CSV com a resposta
             convertToCSV(receita);
             
            System.out.println(receita.length);
            System.out.println("Receita [" + "agencia= "+  receita[0]   + "conta= "+  conta    +"saldo= " + receita[2] + " , status=" + receita[3] +  " , resposta=" + receita[4] +   "]");



        } catch (IOException e) {
            e.printStackTrace();
        }
		
        
	      
		
		
		
		
		
	}

	
	

	public static String removeChar(String s, char c) {
		  StringBuffer r = new StringBuffer( s.length() );
		  r.setLength( s.length() );
		  int current = 0;
		  for (int i = 0; i < s.length(); i ++) {
		     char cur = s.charAt(i);
		     if (cur != c) r.setCharAt( current++, cur );
		  }
		  return r.toString();
		}
	
	
	public static String[] add(String[] originalArray, String newItem)
	{
	    int currentSize = originalArray.length;
	    int newSize = currentSize + 1;
	    String[] tempArray = new String[ newSize ];
	    for (int i=0; i < currentSize; i++)
	    {
	        tempArray[i] = originalArray [i];
	    }
	    tempArray[newSize- 1] = newItem;
	    return tempArray;   
	}


	public static  void convertToCSV (String[] data) {
	 	     
	    PrintWriter pw = null;
        try {
            pw = new PrintWriter(new File("newReceitaRespota.csv"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        StringBuilder builder = new StringBuilder();
        String columnNamesList = "Agencia,conta,saldo,status,resposta";
        // No need give the headers Like: id, Name on builder.append
        builder.append(columnNamesList +"\n");
        builder.append(data[0] + " ");
        builder.append(data[1]+ " ");
        builder.append(data[2]+ " ");
        builder.append(data[3]+ " ");
        builder.append(data[4]+ " ");
        builder.append('\n');
        pw.write(builder.toString());
        pw.close();
        System.out.println("done!");
    }
	    
	    
	    
	

}




