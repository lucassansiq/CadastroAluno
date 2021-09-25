/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

/**
 *
 * @author Lucas Hype
 */
public class Mascara {
    
    public static DefaultFormatterFactory maskData(){
      MaskFormatter mask = null;
      try{
          mask = new MaskFormatter("##/##/####");
          mask.setPlaceholderCharacter('_');
      }catch(ParseException ex){
          return null;
      }
      return (new DefaultFormatterFactory(mask,mask));
    }
    
    public static DefaultFormatterFactory maskTelefone(){
      MaskFormatter mask = null;
      try{
          mask = new MaskFormatter("(##) ####-####");
          mask.setPlaceholderCharacter('_');
      }catch(ParseException ex){
          return null;
      }
      return (new DefaultFormatterFactory(mask,mask));
    }
    
    public static DefaultFormatterFactory maskCelular(){
      MaskFormatter mask = null;
      try{
          mask = new MaskFormatter("(##) ###-###-###");
          mask.setPlaceholderCharacter('_');
      }catch(ParseException ex){
          return null;
      }
      return (new DefaultFormatterFactory(mask,mask));
    }

}
