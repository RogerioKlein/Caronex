/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apoio;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Rogério H. Klein <rhklein@universo.univates.br>
 */
public class NumberLimit extends PlainDocument {
    private int qtdMax;

    public NumberLimit(int maxLen) {
        super();
        if(maxLen<=0)
            throw new IllegalArgumentException("Especificar a quantidade");
        qtdMax = maxLen;
    }
    @Override
    public void insertString(int offset,String str, AttributeSet attr)
            throws BadLocationException{
        if(str==null||getLength()==qtdMax)
            return;
        int totalquantia =(getLength()+str.length());
        if(totalquantia<=qtdMax){
            super.insertString(offset, str.replaceAll("[^0-9]",""), attr);
            return;
        }
        String nova = str.substring(0,getLength()-qtdMax);
        super.insertString(offset, nova, attr);
                
    }
}
