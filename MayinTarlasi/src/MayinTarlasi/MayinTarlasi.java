package MayinTarlasi;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class MayinTarlasi extends JFrame implements MouseListener, ActionListener {
    int height,width,mS,indis[][];
    int kalan_Mayin;
    int count =0;
    javax.swing.JFrame frame = new javax.swing.JFrame("Mayin Tarlasi");
    javax.swing.JPanel jPanel2 = new javax.swing.JPanel();
    javax.swing.JButton jButton1 = new javax.swing.JButton();
    javax.swing.JLabel jLabel1 = new javax.swing.JLabel();
    javax.swing.JLabel jLabel2 = new javax.swing.JLabel();
    javax.swing.JTextField jTextField1 = new javax.swing.JTextField();
    javax.swing.JTextField jTextField2 = new javax.swing.JTextField();
    JPanel S = new JPanel();
    JPanel W = new JPanel();
    JPanel E = new JPanel();
    Container grid = new Container();
    JButton[][] Buttons;
    
    public MayinTarlasi(int height, int width, int mS) {
        this.height = height;
        this.width = width;
        this.mS = mS;
        kalan_Mayin=mS;
        indis = new int[height][width];
        Buttons = new JButton[height][width];
        frame.setLayout(new BorderLayout(5,5));
        frame.setSize(width*30+110,height*30+180);
        S.setSize(new Dimension(width*30+20, 10));
        W.setSize(new Dimension(10, height*30));
        E.setSize(new Dimension(10, height*30));
        grid.setLayout(new GridLayout(height,width));
        frame.setJMenuBar(MenuCubuguOlustur());
        //frame.setResizable(false);
    }
    public MayinTarlasi() {
        this.height = 9;
        this.width = 9;
        this.mS = 10;
        this.kalan_Mayin=mS;
        indis = new int[height][width];
        Buttons = new JButton[height][width];
        frame.setLayout(new BorderLayout(5,5));
        frame.setSize(width*30+110,height*30+180);
        S.setSize(new Dimension(width*30+20, 10));
        W.setSize(new Dimension(10, height*30));
        E.setSize(new Dimension(10, height*30));
        grid.setLayout(new GridLayout(height,width));
        frame.setJMenuBar(MenuCubuguOlustur());
        //frame.setResizable(false);
    }
    
    public void createTarla(){
        int i=0,j=0;
        count = 0;
        while (i<height) {            
            while (j<width) {                
                try {
                    Image img = ImageIO.read(getClass().getResource("/kaynak/b1.png"));
                    Buttons[i][j]=new JButton();
                    Buttons[i][j].setIcon(new ImageIcon(img));
                    Buttons[i][j].addActionListener(this);
                    Buttons[i][j].addMouseListener(this);
                    grid.add(Buttons[i][j]);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
                j++;
            }
            i++;
        }
        Random rnd = new Random();
        ArrayList<Integer> mayinTablosu = new ArrayList<>(mS);
        int sayac = 0;
        while (sayac != mS) {         
            int h=rnd.nextInt(height);
            int w=rnd.nextInt(width);
            int x =Integer.parseInt(h+""+w);
            if(!mayinTablosu.contains(x)) {
                mayinTablosu.add(x);
                sayac++;
                indis[h][w]=-1;
            }
        }
        while (i<height) {            
            while (j<width) {                
                if (indis[i][j]!=-1) {
                    int x=EtraftaMayinSayisi(i, j);
                    indis[i][j]=x;
                }
                j++;
            }
            i++;
        }
        
        jLabel1.setText("Kalan Mayin");
        jLabel2.setText("Gecen Sure");
        jTextField1.setForeground(Color.red);
        jTextField1.setText(String.valueOf(kalan_Mayin));
        jTextField1.setEditable(false);
        jTextField2.setEditable(false);
        jTextField2.setForeground(Color.red);
        jTextField2.setText("         ");
        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jButton1.setBackground(Color.white);
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kaynak/sm.png")));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TarlaYenile();
            }
        });

        frame.add(grid,BorderLayout.CENTER);
        frame.add(jPanel2,BorderLayout.NORTH);
        frame.add(S,BorderLayout.SOUTH);
        frame.add(W,BorderLayout.WEST);
        frame.add(E,BorderLayout.EAST);
 
        frame.setLocationRelativeTo(null);      
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    public void TarlaYenile(){
        count=0;
        int i=0,j=0;
        while (i<height) {            
            while (j<width) {                
                Buttons[i][j].setEnabled(true);
                indis[i][j]=0;
                try {
                    Image img = ImageIO.read(getClass().getResource("/kaynak/b1.png"));
                    Buttons[i][j].setIcon(new ImageIcon(img));
                    
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                j++;
            }
            i++;
        }
        Random rnd = new Random();
        ArrayList<Integer> mTablosu = new ArrayList<>(mS);
        int sayac = 0;
        while (sayac != mS) {         
            int h=rnd.nextInt(height);
            int w=rnd.nextInt(width);
            int x =Integer.parseInt(h+""+w);
            if(!mTablosu.contains(x)) {
                mTablosu.add(x);
                sayac++;
                indis[h][w]=-1;
            }
        }
        while (i<height) {            
            while (j<width) {                
                if (indis[i][j]!=-1) {
                    int x=EtraftaMayinSayisi(i, j);
                    indis[i][j]=x;
                }
                j++;
            }
            i++;
        }
    }
    
    JMenuBar MenuCubuguOlustur() {
       JMenuBar menuBar = new JMenuBar();
       JMenu menu = new JMenu("Setting");
       JMenu about = new JMenu("About");
       
       
       JMenuItem Hakkinda2 = new JMenuItem("Hoca Bilgileri");
       JMenuItem Hakkinda3 = new JMenuItem("Ogrenci Bilgileri");
       
       JMenuItem kolaySec = new JMenuItem("Kolay");
       JMenuItem OrtaSec = new JMenuItem("Orta");
       JMenuItem ZorSec = new JMenuItem("Zor");
       JMenuItem Ozel = new JMenuItem("Ozel");
       JMenuItem Cik = new JMenuItem("Oyundan Cik");
       
       kolaySec.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               frame.setEnabled(false);
               frame.setVisible(false);
               MayinTarlasi m = new MayinTarlasi(9, 9, 10);
               m.createTarla();
               m.start();
               //JOptionPane.showMessageDialog(null,"Kolay","Kolay", JOptionPane.PLAIN_MESSAGE);
           }
       });
       OrtaSec.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               frame.setEnabled(false);
               frame.setVisible(false);
               MayinTarlasi m = new MayinTarlasi(16, 16, 40);
               m.createTarla();
               m.start();
               //JOptionPane.showMessageDialog(null,"Orta","Orta", JOptionPane.PLAIN_MESSAGE);
           }
       });
       ZorSec.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               frame.setEnabled(false);
               frame.setVisible(false);
               MayinTarlasi m = new MayinTarlasi(16, 30, 99);
               m.createTarla();
               m.start();
               
           }
       });
       Ozel.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
                JFrame fr = new JFrame("Custom");
                Container container = fr.getContentPane();
                GroupLayout groupLayout = new GroupLayout(container);
                container.setLayout(groupLayout);
                groupLayout.setAutoCreateGaps(true);
                groupLayout.setAutoCreateContainerGaps(true);
                groupLayout.preferredLayoutSize(container);
                JLabel label_1 = new JLabel("height");
                JLabel label_2 = new JLabel("width");
                JLabel label_3 = new JLabel("Mayin Sayisi");
                JTextField textField_1 = new JTextField();
                JTextField textField_2 = new JTextField();
                JTextField textField_3 = new JTextField();
                JButton button_1 = new JButton("createTarla");
                JButton button_2 = new JButton("iptal");
                button_1.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        String yy =textField_1.getText();
                        int y = Integer.parseInt(yy);
                        String gg =textField_2.getText();
                        int g = Integer.parseInt(gg);
                        String z =textField_3.getText();
                        int m = Integer.parseInt(z);
                        frame.setEnabled(false);
                        frame.setVisible(false);
                        fr.setEnabled(false);
                        fr.setVisible(false);
                        MayinTarlasi mm = new MayinTarlasi(y, g, m);
                        mm.createTarla();  
                        mm.start();
                    }
                });
                button_2.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent ae) {
                        fr.setVisible(false);
                    }
                });
                
                groupLayout.setHorizontalGroup(
                    groupLayout.createSequentialGroup()
                
                    .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(label_1)
                    .addComponent(label_2)
                    .addComponent(label_3)
                    )
                
                .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(textField_1)
                    .addComponent(textField_2)
                    .addComponent(textField_3)
 
                    
                    .addGroup(groupLayout.createSequentialGroup()
                        .addComponent(button_1)
                        .addComponent(button_2)
                        
                        )
                    )
                );
 
        
            groupLayout.setVerticalGroup(
                groupLayout.createSequentialGroup()
                
                    .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(label_1)
                    .addComponent(textField_1)
                    )
                
                    .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(label_2)
                    .addComponent(textField_2)
                    )
                    .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(label_3)
                    .addComponent(textField_3)
                    )
                
                    .addGroup(groupLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(button_1)
                    .addComponent(button_2)
                    
                    )
            );
        fr.setLocationRelativeTo(frame);
        fr.pack();                                          
        fr.setVisible(true);
        
        
           }
       }); 
       Cik.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent ae) {
               frame.setEnabled(false);
               frame.setVisible(false);
               System.exit(0);
           }
       });

       Hakkinda2.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent ae) {
               JOptionPane.showMessageDialog(null,"Doç. Dr. Fatih ÖZKAYNAK","Sorumlu Hoca Bilgisi", JOptionPane.PLAIN_MESSAGE);
           }
       });
       Hakkinda3.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent ae) {
               JOptionPane.showMessageDialog(null,"Öğrenci No : 170541614 \nÖğrenci Adı : Hibe Alabd ","Öğrenci Bilgisi", JOptionPane.PLAIN_MESSAGE);
           }
       });
       
       about.add(Hakkinda2);
       about.add(Hakkinda3);
       menu.add(kolaySec);
       menu.add(OrtaSec);
       menu.add(ZorSec);
       menu.add(Ozel);
       menu.add(Cik);
       menuBar.add(menu);
       menuBar.add(about);
       return menuBar;
   }
    
    public final int EtraftaMayinSayisi(int i, int j){
        int s=0;
        if ((i+1)<height && (j+1)<width) 
            if (indis[i+1][j+1] == -1) 
                s++;
        if ((i-1)>=0 && (j-1)>=0) 
            if (indis[i-1][j-1] ==-1) 
                s++;
        if (i+1 < height) 
            if (indis[i+1][j] ==-1) 
                s++;
        if (j+1 < width) 
            if (indis[i][j+1] ==-1) 
                s++;
        if (i-1 >=0) 
            if (indis[i-1][j] ==-1) 
                s++;
        if (j-1 >= 0) 
            if (indis[i][j-1] ==-1) 
                s++;
        if ((i+1)<height && (j-1)>=0) 
            if (indis[i+1][j-1] ==-1) 
                s++;
        if ((i-1)>=0 && (j+1)<width) 
            if (indis[i-1][j+1] ==-1) 
                s++;
        
        return s;
    }
    
    public void Tikla(int i,int j) throws IOException{
        if ((i+1)<height && (j+1)<width){ 
            if (indis[i+1][j+1] !=-1){ 
                if (indis[i+1][j+1]!=0) {
                    String s = "/kaynak/"+String.valueOf(indis[i+1][j+1])+".png";
                    Image img = ImageIO.read(getClass().getResource(s));
                    Buttons[i+1][j+1].setDisabledIcon(new ImageIcon(img));
                    Buttons[i+1][j+1].setEnabled(false);
                }
                else{
                    Buttons[i+1][j+1].setEnabled(false);
                }
            }
        }
        if ((i-1)>=0 && (j-1)>=0) {
            if (indis[i-1][j-1] !=-1) {
                if (indis[i-1][j-1]!=0) {
                    String s = "/kaynak/"+String.valueOf(indis[i-1][j-1])+".png";
                    Image img = ImageIO.read(getClass().getResource(s));
                    Buttons[i-1][j-1].setDisabledIcon(new ImageIcon(img));
                    Buttons[i-1][j-1].setEnabled(false);
                } 
                else {
                    Buttons[i-1][j-1].setEnabled(false);
                }
            }
        }
        if (i+1 < height) {
            if (indis[i+1][j] !=-1) {
                if (indis[i+1][j] != 0) {
                    String s = "/kaynak/"+String.valueOf(indis[i+1][j])+".png";
                    Image img = ImageIO.read(getClass().getResource(s));
                    Buttons[i+1][j].setDisabledIcon(new ImageIcon(img));
                    Buttons[i+1][j].setEnabled(false);
                } 
                else {
                    Buttons[i+1][j].setEnabled(false);
                }
            }
        }
        if (j+1 < width) {
            if (indis[i][j+1] !=-1) {
                if (indis[i][j+1] !=0) {
                    String s = "/kaynak/"+String.valueOf(indis[i][j+1])+".png";
                    Image img = ImageIO.read(getClass().getResource(s));
                    Buttons[i][j+1].setDisabledIcon(new ImageIcon(img));
                    Buttons[i][j+1].setEnabled(false);
                } 
                else {
                    Buttons[i][j+1].setEnabled(false);
                }
            }
        }
        if (i-1 >=0) {
            if (indis[i-1][j] !=-1) {
                if (indis[i-1][j] !=0) {
                    String s = "/kaynak/"+String.valueOf(indis[i-1][j])+".png";
                    Image img = ImageIO.read(getClass().getResource(s));
                    Buttons[i-1][j].setDisabledIcon(new ImageIcon(img));
                    Buttons[i-1][j].setEnabled(false);
                } 
                else {
                    Buttons[i-1][j].setEnabled(false);
                }
            }
        }
        if (j-1 >= 0) {
            if (indis[i][j-1] !=-1) {
                if (indis[i][j-1] !=0) {
                    String s = "/kaynak/"+String.valueOf(indis[i][j-1])+".png";
                    Image img = ImageIO.read(getClass().getResource(s));
                    Buttons[i][j-1].setDisabledIcon(new ImageIcon(img));
                    Buttons[i][j-1].setEnabled(false);
                } 
                else {
                    Buttons[i][j-1].setEnabled(false);
                }
            }
        }
        if ((i+1)<height && (j-1)>=0) {
            if (indis[i+1][j-1] !=-1) {
                if (indis[i+1][j-1]!=0) {
                    String s = "/kaynak/"+String.valueOf(indis[i+1][j-1])+".png";
                    Image img = ImageIO.read(getClass().getResource(s));
                    Buttons[i+1][j-1].setDisabledIcon(new ImageIcon(img));
                    Buttons[i+1][j-1].setEnabled(false);
                } 
                else {
                    Buttons[i+1][j-1].setEnabled(false);
                }
            }
        }
        if ((i-1)>=0 && (j+1)<width) {
            
            if (indis[i-1][j+1] !=-1) {
                if (indis[i-1][j+1] !=0) {
                    String s = "/kaynak/"+String.valueOf(indis[i-1][j+1])+".png";
                    Image img = ImageIO.read(getClass().getResource(s));
                    Buttons[i-1][j+1].setDisabledIcon(new ImageIcon(img));
                    Buttons[i-1][j+1].setEnabled(false);
                } 
                else {
                    Buttons[i-1][j+1].setEnabled(false);
                } 
            }
        }
    }
    
    public void dominolistesi(int i, int j) throws IOException{
        ArrayList<Integer> aa = new ArrayList<>(width*height);
        aa.add(Integer.parseInt(i+""+j));
        int ii=i,jj=j;
        int s=0;
        boolean b =true;
        Tikla(i, j);
        while (b) {
            ii=aa.get(s)/10;
            jj=aa.get(s)%10;
            int X[] = { 1,-1, 0, 0, 1,-1, 1,-1 }; 
            int Y[] = { 0, 0, 1,-1, 1,-1,-1, 1 }; 
            for (int k = 0; k < 8; k++) {
                ii+=X[k];
                jj+=Y[k];
                if (((ii>=0)&&(ii<height))&&((jj>=0)&&(jj<height))) {
                    if ((!aa.contains(Integer.parseInt(ii+""+jj)))&& indis[ii][jj]!= -1) {
                        aa.add(Integer.parseInt(ii+""+jj));
                    }
                    if (indis[ii][jj]== -1) {
                    b=false;
                    }
                }
            }
            s++;
        }
        for (int k = 0; k < aa.size(); k++) {
            Tikla(aa.get(k)/10, aa.get(k)%10);
        }
        
    }
    
    public void getLose() {
        int i=0,j=0;
        while (i<height) {            
            while (j<width) {                
                if (indis[i][j]==-1) {
                    try {
                        Image img = ImageIO.read(getClass().getResource("/kaynak/m2.png"));    
                        Buttons[i][j].setDisabledIcon(new ImageIcon(img));
                        Buttons[i][j].setEnabled(false);
                        Buttons[i][j].setBackground(Color.WHITE);
                    } 
                    catch (Exception e) {
                        }
                    
                    
                }
                else{
                    Buttons[i][j].setEnabled(false);
                }
                j++;
            }
            i++;
        }
        int q =JOptionPane.showConfirmDialog(null, "Maalesef Kayip ettin \n Yeniden oynamak ister misin?" , "Kaybettin",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if (q== JOptionPane.YES_OPTION) {
            frame.setEnabled(false);
            frame.setVisible(false);
            MayinTarlasi mm = new MayinTarlasi(9, 9, 10);
            mm.createTarla();
            mm.start();
        }
        else if(q==JOptionPane.NO_OPTION){
            frame.setEnabled(false);
            frame.setVisible(false);
            System.exit(0);
        }
    }
    
    public void getWin() throws Exception{
        int i=0,j=0;
        while (i<height) {            
            while (j<width) {                
                if (indis[i][j]==-1) {
                    Image img = ImageIO.read(getClass().getResource("/kaynak/m1.png"));
                    Buttons[i][j].setIcon(new ImageIcon(img));
                    Buttons[i][j].setBackground(Color.white);
               }
                else
                    Buttons[i][j].setEnabled(false);
                j++;
            }
            i++;
        }
        int x =JOptionPane.showConfirmDialog(null, "Tebrikeler Kazandin yeniden oynamak istermisin ?" , "Kazndin",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        if (x== JOptionPane.YES_OPTION) {
            frame.setEnabled(false);
            frame.setVisible(false);
            MayinTarlasi m = new MayinTarlasi(9, 9, 10);
            m.createTarla();
            m.start();
        }
        else if(x== JOptionPane.NO_OPTION){
            frame.setEnabled(false);
            frame.setVisible(false);
            System.exit(0);
        }
    }
    

    public boolean KazandinMi() {
        int s=0;
        int i=0,j=0;
        while (i<height) {            
            while (j<width) {                
                if (! Buttons[i][j].isEnabled()) {
                    s++;
                }
                j++;
            }
            i++;
        }
        return (s== width*height - mS);
    }
    public boolean tumMayinlerIsaretlendi() {
        int i=0,j=0;
        while (i<height) {            
            while (j<width) {                
                if (indis[i][j]==-1) {
                    if (Buttons[i][j].isEnabled()) {
                        return false;
                    }
                }
                j++;
            }
            i++;
        }
        return true;
    }
    
    Timer t = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            jTextField2.setText(String.valueOf(count));
            count++;
        }
    };
    public void start(){
        t.scheduleAtFixedRate(task, 1000, 1000);
    }
    
    public static void main(String[] args) {
        MayinTarlasi m = new MayinTarlasi(9,9,10);
        m.createTarla();
        m.start();
    }
    public void mouseClicked(MouseEvent me) {
        int i=0,j=0;
        try {
            if(SwingUtilities.isRightMouseButton(me)){
                while (i<height) {            
                    while (j<width) {                
                        if (me.getSource() == Buttons[i][j]) {
                            if (Buttons[i][j].isEnabled()) {
                                Image img = ImageIO.read(getClass().getResource("/kaynak/f1.png"));
                                kalan_Mayin--;
                                Buttons[i][j].setEnabled(false);
                                Buttons[i][j].setDisabledIcon(new ImageIcon(img));
                            }
                            else{
                            kalan_Mayin++;
                            Image img = ImageIO.read(getClass().getResource("/kaynak/b1.png"));
                            Buttons[i][j].setEnabled(true);
                            Buttons[i][j].setIcon(new ImageIcon(img));
                            }
                        }
                        j++;
                    }
                    i++;
                }
                jTextField1.setText(String.valueOf(kalan_Mayin));
            }
        } 
        catch (Exception e) {
        }
        if (tumMayinlerIsaretlendi()) {
            try {
                getWin();
            } catch (Exception ex) {
                Logger.getLogger(MayinTarlasi.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
                }
    }
    public void mousePressed(MouseEvent me) {
        try {
            
        } catch (Exception e) {
        }
    }
    public void mouseReleased(MouseEvent me) {
        try {
            
        } catch (Exception e) {
        }
    }
    public void mouseEntered(MouseEvent me) {
        try {
            
        } catch (Exception e) {
        }
    }
    public void mouseExited(MouseEvent me) {
        try {
            
        } catch (Exception e) {
        }
    }
    public void actionPerformed(ActionEvent ae) {
        int i=0,j=0;
        try {
            while (i<height) {            
                while (j<width) {                
                    if (ae.getSource() == Buttons[i][j]) {
                        if (indis[i][j]==-1) {
                            getLose();
                        }
                        else{
                            if (indis[i][j]==0) {
                                Buttons[i][j].setEnabled(false);
                                dominolistesi(i, j);
                            }
                            else{
                                Buttons[i][j].setEnabled(false);
                                String s = "/kaynak/"+String.valueOf(indis[i][j])+".png";
                                Image img = ImageIO.read(getClass().getResource(s));
                                Buttons[i][j].setDisabledIcon(new ImageIcon(img));
                            }
                        }
                    }
                    j++;
                }
                i++;
            }
            if (KazandinMi()) {
                getWin();
            }
        } 
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

