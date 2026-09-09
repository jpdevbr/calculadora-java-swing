import javax.swing.*;
import java.awt.*;

class Operacao {

    public float Porcentagem(float num1, float num2){
        float resutado = num1 * (num2/100);       
        return resutado;
    }

    public double raiz(double num1) {
        double resutado = Math.sqrt(num1);

        return resutado;
    }

    public float soma(float num1, float num2) {
        float resutado = num1 + num2;

        return resutado;
    }

    public float subtracao(float num1, float num2) {
        float resutado = num1 - num2;

        return resutado;
    }

    public float mutiplicacao(float num1, float num2) {
        float resutado = num1 * num2;

        return resutado;
    }

    public float divisao(float num1, float num2) {
        if (num2 == 0) {
            throw new ArithmeticException("não é possivel dividir por zero...");
        }
        float resutado = num1 / num2;
        return resutado;
    }
}

public class Interface extends JFrame {

    float num1;
    String operacao;
    public void estilizarBotaoOperacao(JButton botao) {
        botao.setFont(new Font("Arial", Font.BOLD, 18));
        botao.setBackground(Color.DARK_GRAY);
        botao.setForeground(Color.WHITE);
    }

    public void estilizarBotaonum(JButton botao){
        botao.setFont(new Font("Arial", Font.BOLD, 18));
        botao.setBackground(Color.ORANGE);
        botao.setForeground(Color.WHITE);
    }

    public void  estilizarBotaoVisor(JTextField visor){
        visor.setFont(new Font("Arial", Font.BOLD, 18));
        visor.setBackground(Color.GRAY);
        visor.setForeground(Color.WHITE);
    }

    public Interface() {
        setTitle("calculadora");
        
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JTextField visor = new JTextField();
        add(visor, BorderLayout.NORTH);
        visor.setEditable(false);

        JPanel panelButaos = new JPanel();
        panelButaos.setLayout(new GridLayout(5, 4));

        JButton buttonC = new JButton("C");
        panelButaos.add(buttonC);
        JButton buttonBack = new JButton("←");
        panelButaos.add(buttonBack);
        JButton buttonPorCento = new JButton("%");
        panelButaos.add(buttonPorCento);

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

        JButton buttonRaiz = new JButton("√");
        panelButaos.add(buttonRaiz);

        JButton buttonZero = new JButton("0");
        panelButaos.add(buttonZero);
        JButton buttonPoint = new JButton(".");
        panelButaos.add(buttonPoint);
        JButton buttonIgual = new JButton("=");
        panelButaos.add(buttonIgual);

        JButton buttonDiv = new JButton("/");
        panelButaos.add(buttonDiv);

        buttonSete.addActionListener(e -> {
            visor.setText(visor.getText() + "7");
        });
        buttonOito.addActionListener(e -> {
            visor.setText(visor.getText() + "8");
        });

        buttonNove.addActionListener(e -> {
            visor.setText(visor.getText() + "9");
        });
        buttonQuatro.addActionListener(e -> {
            visor.setText(visor.getText() + "4");
        });
        buttonCinco.addActionListener(e -> {
            visor.setText(visor.getText() + "5");
        });
        buttonSeis.addActionListener(e -> {
            visor.setText(visor.getText() + "6");
        });
        buttonUm.addActionListener(e -> {
            visor.setText(visor.getText() + "1");
        });
        buttonDois.addActionListener(e -> {
            visor.setText(visor.getText() + "2");
        });
        buttonTres.addActionListener(e -> {
            visor.setText(visor.getText() + "3");
        });
        buttonZero.addActionListener(e -> {
            visor.setText(visor.getText() + "0");
        });
        buttonPoint.addActionListener(e -> {
            visor.setText(visor.getText() + ".");
        });
        buttonC.addActionListener(e -> {
            visor.setText("");
        });
        buttonBack.addActionListener(e -> {
            String texto = visor.getText();
            if (!texto.isEmpty()) {
                visor.setText(texto.substring(0, texto.length() - 1));
            }
        });

        buttonmais.addActionListener(e -> {
            operacao = "+";
            num1 = Float.parseFloat(visor.getText());
            visor.setText("");

        });

        buttonmenos.addActionListener(e -> {
            operacao = "-";
            num1 = Float.parseFloat(visor.getText());
            visor.setText("");

        });

        buttonveses.addActionListener(e -> {
            operacao = "*";
            num1 = Float.parseFloat(visor.getText());
            visor.setText("");

        });
        buttonDiv.addActionListener(e -> {
            operacao = "/";
            num1 = Float.parseFloat(visor.getText());
            visor.setText("");

        });

        Operacao operacao1 = new Operacao();

        buttonRaiz.addActionListener(e -> {
            float num1 = Float.parseFloat(visor.getText());
            double resutado = operacao1.raiz(num1);
            visor.setText(String.valueOf(resutado));
        });

        buttonPorCento.addActionListener(e ->{
            operacao = "%";
            num1 = Float.parseFloat(visor.getText());
            visor.setText("");
        });

        buttonIgual.addActionListener(e -> {
            float num2 = Float.parseFloat(visor.getText());

            switch (operacao) {
                case "+": {
                    float resutado = operacao1.soma(num1, num2);
                    visor.setText(String.valueOf(resutado));
                    break;

                }
                case "-": {
                    float resutado = operacao1.subtracao(num1, num2);
                    visor.setText(String.valueOf(resutado));
                    break;
                }
                case "*": {
                    float resutado = operacao1.mutiplicacao(num1, num2);
                    visor.setText(String.valueOf(resutado));
                    break;
                }
                case "/": {
                    float resutado = operacao1.divisao(num1, num2);
                    visor.setText(String.valueOf(resutado));
                    break;
                }
                case "%": {
                    float resutado = operacao1.Porcentagem(num1, num2);
                    visor.setText(String.valueOf(resutado));
                    break;
                }
            }
            


        });
        estilizarBotaoOperacao(buttonC);
        estilizarBotaoOperacao(buttonBack);
        estilizarBotaoOperacao(buttonDiv);
        estilizarBotaoOperacao(buttonmais);
        estilizarBotaoOperacao(buttonmenos);
        estilizarBotaoOperacao(buttonIgual);
        estilizarBotaoOperacao(buttonPorCento);
        estilizarBotaoOperacao(buttonPoint);
        estilizarBotaoOperacao(buttonveses);
        estilizarBotaoOperacao(buttonRaiz);
        estilizarBotaonum(buttonUm);
        estilizarBotaonum(buttonDois);
        estilizarBotaonum(buttonTres);
        estilizarBotaonum(buttonQuatro);
        estilizarBotaonum(buttonCinco);
        estilizarBotaonum(buttonSeis);
        estilizarBotaonum(buttonSete);
        estilizarBotaonum(buttonOito);
        estilizarBotaonum(buttonNove);
        estilizarBotaonum(buttonZero);
        estilizarBotaoVisor(visor);

        add(panelButaos, BorderLayout.CENTER);
        setVisible(true);
    }

}

class Main {
    public static void main(String[] args) {
        new Interface();
    }
}