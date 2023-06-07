/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package threads;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author professores
 */
public class GeradorMultas {
        
    public String sorteiaPlaca(){
//        Random r = new Random();
//        while(true){
//            int aux =  r.nextInt(10);
//            System.out.println(aux);
//            if(aux == 9) break;
//        }
        /// AAA-9999
        /// AAA-9A99
        String result = "";
        Random r = new Random();
        char sorteado =  (char) r.nextInt(26);
        char letra = (char) ('A' + sorteado);
        result += letra;
        
        sorteado =  (char) r.nextInt(26);
        letra = (char) ('A' + sorteado);
        result += letra;
        
        sorteado =  (char) r.nextInt(26);
        letra = (char) ('A' + sorteado);
        result += letra;
        
        result += '-';
        
        result += r.nextInt(10);
        result += r.nextInt(10);
        result += r.nextInt(10);
        result += r.nextInt(10);
        
        return result;
        
    }
    
    public double sorteiaValor(){
        double valores[] = {88.38, 130.16, 195.23, 293.47};
        Random r = new Random();
        double result = valores[r.nextInt(4)];
        if(result == 293.47) result *= (r.nextInt(10)+1);
        
        return result;
    }
    
    public void salvaMultas(long quant, String nomeArq){
        
        try(PrintWriter pw = new PrintWriter(new File(nomeArq))){
            
            for (long i = 0; i < quant; i++)
                pw.println(sorteiaPlaca() + " " + sorteiaValor());
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }
    
}
