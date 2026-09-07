import javax.swing.*;
import java.awt.*;



class Operacao{
    
    public float soma(float num1, float num2){
        float resutado = num1 + num2;
        
        return resutado;
    }

    public float subtracao(float num1, float num2){    
        float resutado = num1 - num2;
        
        return resutado;
    }
    public float mutiplicacao(float num1, float num2){
        float resutado = num1 * num2;
        
        return resutado;
    }
    public float divisao(float num1, float num2){
        if (num2 == 0) {
            throw new  ArithmeticException("não é possivel dividir por zero...");
        }
        float resutado = num1 / num2;
        return resutado;
    }
}


public class Interface extends JFrame {

    float num1;
    String operacao;

    public Interface(){
        setTitle("calculadora");;
        setSize(300,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JTextField visor = new JTextField();
        add(visor, BorderLayout.NORTH);
        visor.setEditable(false);
        
        JPanel panelButaos = new JPanel();
        panelButaos.setLayout(new GridLayout(5,4));
        
        JButton buttonC = new JButton("C");
        panelButaos.add(buttonC);
        JButton buttonBack = new JButton("←");
        panelButaos.add(buttonBack);
        JButton buttonDiv = new JButton("/");
        panelButaos.add(buttonDiv);
        
        JButton buttonmais = new JButton("+");
        panelButaos.add(buttonmais);

        JButton buttonSete = new JButton("7");
        panelButaos.add(buttonSete);
        JButton buttonOito = new JButton("8");
        panelButaos.add(buttonOito);
        JButton buttonNove = new JButton("9");
        panelButaos.add(buttonNove);
        
        JButton buttonmenos = new JButton("-");
        panelButaos.add(buttonmenos);

        JButton buttonQuatro = new JButton("4");
        panelButaos.add(buttonQuatro);
        JButton buttonCinco = new JButton("5");
        panelButaos.add(buttonCinco);
        JButton buttonSeis = new JButton("6");
        panelButaos.add(buttonSeis);
        
        JButton buttonveses = new JButton("x");
        panelButaos.add(buttonveses);

        JButton buttonUm = new JButton("1");
        panelButaos.add(buttonUm);
        JButton buttonDois = new JButton("2");
        panelButaos.add(buttonDois);
        JButton buttonTres = new JButton("3");
        panelButaos.add(buttonTres);
        
        panelButaos.add(new JButton());

        JButton buttonZero = new JButton("0");
        panelButaos.add(buttonZero);
        JButton buttonPoint = new JButton(".");
        panelButaos.add(buttonPoint);
        JButton buttonIgual = new JButton("=");
        panelButaos.add(buttonIgual);

        panelButaos.add(new JButton());
        
        buttonSete.addActionListener(e -> {
            visor.setText(visor.getText()+"7");
        });
        buttonOito.addActionListener(e ->{
            visor.setText(visor.getText()+"8");
        });
        
        buttonNove.addActionListener(e -> {
            visor.setText(visor.getText()+"9");
        });
        buttonQuatro.addActionListener(e -> {
            visor.setText(visor.getText()+"4");
        });
        buttonCinco.addActionListener(e -> {
            visor.setText(visor.getText()+"5");
        });
        buttonSeis.addActionListener(e -> {
            visor.setText(visor.getText()+"6");
        });
        buttonUm.addActionListener(e -> {
            visor.setText(visor.getText()+"1");
        });
        buttonDois.addActionListener(e -> {
            visor.setText(visor.getText()+"2");
        });
        buttonTres.addActionListener(e -> {
            visor.setText(visor.getText()+"3");
        });
        buttonZero.addActionListener(e -> {
            visor.setText(visor.getText()+"0");
        });
        buttonPoint.addActionListener(e -> {
            visor.setText(visor.getText()+".");
        });
        buttonC.addActionListener(e -> {
            visor.setText("");
        });

        buttonmais.addActionListener(e ->{
            operacao = "+";
            num1 = Float.parseFloat(visor.getText());
            visor.setText("");
            
        });

        buttonmenos.addActionListener(e ->{
            operacao = "-";
            num1 = Float.parseFloat(visor.getText());
            visor.setText("");
            
        });

        buttonveses.addActionListener(e ->{
            operacao = "*";
            num1 = Float.parseFloat(visor.getText());
            visor.setText("");
            
        });
        buttonDiv.addActionListener(e ->{
            operacao = "/";
            num1 = Float.parseFloat(visor.getText());
            visor.setText("");
            
        });

        buttonIgual.addActionListener(e ->{
            float num2 = Float.parseFloat(visor.getText());
            
            Operacao operacao1 = new Operacao();

            switch (operacao) {
                case "+":{
                    float resutado = operacao1.soma (num1,num2);
                    visor.setText(String.valueOf(resutado));
                    break;
                    
                }
                case "-":{
                    float resutado = operacao1.subtracao(num1,num2);
                    visor.setText(String.valueOf(resutado));
                    break;
                }
                case "*":{
                    float resutado = operacao1.mutiplicacao(num1,num2);
                    visor.setText(String.valueOf(resutado));
                    break;
                }
                case "/":{
                    float resutado = operacao1.divisao(num1,num2);
                    visor.setText(String.valueOf(resutado));
                    break;
                }
                
            }

        });

        add(panelButaos, BorderLayout.CENTER);
        setVisible(true);
    }
    
} 

class Main {
    public static void main(String[] args) {
        new Interface();
    }
}