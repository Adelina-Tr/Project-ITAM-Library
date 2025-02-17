import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
public class BibliotecaVista extends JFrame{
	/*
	 * Adelina Trejo Espinoza 168135
	 * Proyecto Final BIBLIOTECA CENTRAL 
	 * Clase vista para presentar ventana al usuario
	 * y trabajar con la Biblioteca
	 * 07/12/16
	 */
	protected JPanel pn1, pnP, pn2;
	protected Border miBorde, miBorde2;
	protected JLabel lbTip, lbTit, lbAut, lbAnioP, lbEdit, lbClas, lbEst,lbRP, lbClave, lbDR, lbVacia, lbLogo;
	protected JTextField txTip, txTit,  txAut, txAnioP, txEdit, txClas, txEst, txRP, txClave, txDR;
	protected JButton btAlta, btBaja, btCxC, btCxE, btCxT, btvCD, btBuscar, btPrestar, btDevolver, btLimpiar, btLogo, btInfo;
	protected JTextArea taInfo;
	
	public BibliotecaVista(){
		super("Biblioteca Central");
		pnP= new JPanel(new GridLayout(1,3));
		miBorde=BorderFactory.createEmptyBorder(0,0,0,0);
		pnP.setBorder(miBorde);
				
		Font formato1 = new Font("Monospaced", Font.BOLD+Font.ITALIC, 14);
		Font formato2= new Font("Berlin Sans FB Demi", Font.BOLD,16);
		Font formato3 = new Font("Monospaced", Font.BOLD, 15);
		
		pn1= new JPanel(new GridLayout(16,4));
		pn1.setBackground(Color.WHITE);
		pnP.add(pn1);
		
		btLogo= new JButton(new ImageIcon("logo.png"));
		btLogo.setBackground(Color.white);
		btLogo.setBorder(null);
		btLogo.setHorizontalAlignment(SwingConstants.RIGHT);
		pn1.add(btLogo);
		
		lbLogo= new JLabel("BIBLIOTECA CENTRAL");
		lbLogo.setFont(formato2);
		pn1.add(lbLogo);
		
		lbVacia= new JLabel("");
		pn1.add(lbVacia);
		lbVacia= new JLabel("");
		pn1.add(lbVacia);	
		lbVacia= new JLabel("");
		pn1.add(lbVacia);
		lbVacia= new JLabel("");
		pn1.add(lbVacia);
		lbVacia= new JLabel("");
		pn1.add(lbVacia);
		lbVacia= new JLabel("");
		pn1.add(lbVacia);
	
		lbTip= new JLabel("TIPO: ");
		lbTip.setFont(formato1);
		lbTip.setHorizontalAlignment(SwingConstants.RIGHT);
		pn1.add(lbTip);
		
		txTip=new JTextField(20);
		pn1.add(txTip);
		
		btCxT= new JButton ("Contar existentes");
		pn1.add(btCxT);
		
		lbVacia= new JLabel("");
		pn1.add(lbVacia);
		
		lbTit= new JLabel("TITULO: ");
		lbTit.setFont(formato1);
		lbTit.setHorizontalAlignment(SwingConstants.RIGHT);
		pn1.add(lbTit);
		
		txTit=new JTextField(30);
		pn1.add(txTit);
		
		btCxE= new JButton ("Contar existentes");
		pn1.add(btCxE);
		
		btvCD= new JButton ("Ejemplares Disponibles");
		pn1.add(btvCD);
		
		lbAut= new JLabel("AUTOR: ");
		lbAut.setFont(formato1);
		lbAut.setHorizontalAlignment(SwingConstants.RIGHT);
		pn1.add(lbAut);
		
		txAut=new JTextField(30);
		pn1.add(txAut);
		
		lbVacia= new JLabel("");
		pn1.add(lbVacia);
		lbVacia= new JLabel("");
		pn1.add(lbVacia);
		
		lbAnioP= new JLabel("ANIO PUBLICACION: ");
		lbAnioP.setFont(formato1);
		lbAnioP.setHorizontalAlignment(SwingConstants.RIGHT);
		pn1.add(lbAnioP);
		
		txAnioP=new JTextField(4);
		pn1.add(txAnioP);
		
		lbVacia= new JLabel("");
		pn1.add(lbVacia);
		lbVacia= new JLabel("");
		pn1.add(lbVacia);
		
		lbEdit= new JLabel("EDITORIAL: ");
		lbEdit.setFont(formato1);
		lbEdit.setHorizontalAlignment(SwingConstants.RIGHT);
		pn1.add(lbEdit);
		
		txEdit=new JTextField(20);
		pn1.add(txEdit);
		
		lbVacia= new JLabel("");
		pn1.add(lbVacia);
		lbVacia= new JLabel("");
		pn1.add(lbVacia);
		
		lbClas= new JLabel("CLASIFICACION: ");
		lbClas.setFont(formato1);
		lbClas.setHorizontalAlignment(SwingConstants.RIGHT);
		pn1.add(lbClas);
		
		txClas=new JTextField(15);
		pn1.add(txClas);
		
		btCxC= new JButton ("Contar existentes");
		pn1.add(btCxC);
		
		lbVacia= new JLabel("");
		pn1.add(lbVacia);
		
		lbEst= new JLabel("ESTANTE: ");
		lbEst.setFont(formato1);
		lbEst.setHorizontalAlignment(SwingConstants.RIGHT);
		pn1.add(lbEst);
		
		txEst=new JTextField(1);
		pn1.add(txEst);
		
		lbVacia= new JLabel("");
		pn1.add(lbVacia);
		lbVacia= new JLabel("");
		pn1.add(lbVacia);
		
		lbRP= new JLabel("RESTRICCION: ");
		lbRP.setFont(formato1);
		lbRP.setHorizontalAlignment(SwingConstants.RIGHT);
		pn1.add(lbRP);
		
		txRP= new JTextField(6);
		pn1.add(txRP);		
		
		lbVacia= new JLabel("");
		pn1.add(lbVacia);
		lbVacia= new JLabel("");
		pn1.add(lbVacia);
		lbVacia= new JLabel("");
		pn1.add(lbVacia);
				
		btAlta=new JButton("Alta");
		pn1.add(btAlta);
		
		lbVacia= new JLabel("");
		pn1.add(lbVacia);
		lbVacia= new JLabel("");
		pn1.add(lbVacia);
		lbVacia= new JLabel("");
		pn1.add(lbVacia);
		lbVacia= new JLabel("");
		pn1.add(lbVacia);
		lbVacia= new JLabel("");
		pn1.add(lbVacia);
		lbVacia= new JLabel("");
		pn1.add(lbVacia);
		lbVacia= new JLabel("");
		pn1.add(lbVacia);
		lbVacia= new JLabel("");
		pn1.add(lbVacia);
		
		btInfo= new JButton("Inventario");
		pn1.add(btInfo);
		
		btLimpiar=new JButton("Limpiar");
		pn1.add(btLimpiar);

		lbClave= new JLabel("CLAVE: ");
		lbClave.setFont(formato1);
		lbClave.setHorizontalAlignment(SwingConstants.RIGHT);
		pn1.add(lbClave);
		
		txClave=new JTextField(4);
		pn1.add(txClave);
		
		btBaja= new JButton ("Baja");
		pn1.add(btBaja);
		
		btBuscar= new JButton ("Buscar");
		pn1.add(btBuscar);		
		
		lbDR= new JLabel("DIAS RETRASO: ");
		lbDR.setFont(formato1);
		lbDR.setHorizontalAlignment(SwingConstants.RIGHT);
		pn1.add(lbDR);
		
		txDR=new JTextField(3);
		pn1.add(txDR);
		
		btDevolver= new JButton ("Devolver");
		pn1.add(btDevolver);
		
		btPrestar= new JButton ("Prestar");
		pn1.add(btPrestar);
		
		lbVacia= new JLabel("");
		pn1.add(lbVacia);
		lbVacia= new JLabel("");
		pn1.add(lbVacia);
		lbVacia= new JLabel("");
		pn1.add(lbVacia);
		lbVacia= new JLabel("");
		pn1.add(lbVacia);
		
		pn2= new JPanel(new GridLayout(1,1));
		miBorde2=BorderFactory.createEmptyBorder(100,100,100,70);
		pn2.setBorder(miBorde2);
		pn2.setBackground(Color.WHITE);
		pnP.add(pn2);
		
		taInfo= new JTextArea();
		taInfo.setBackground(Color.white);
		taInfo.setForeground(Color.black);
		taInfo.setFont(formato3);
		taInfo.setEditable(false);
		pn2.add(taInfo);
		
		JScrollPane scroll = new JScrollPane (taInfo,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pn2.add(scroll);
		
		super.setContentPane(pnP);
		super.setBounds(1,100,1350,500);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		super.setVisible(true);
	}
}




