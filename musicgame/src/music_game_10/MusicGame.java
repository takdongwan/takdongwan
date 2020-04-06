package music_game_10;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MusicGame extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;
	
	
	
	private ImageIcon exitButtonEnterdImage = new ImageIcon(Main.class.getResource("../images/exitButtonEntered.png"));
	private ImageIcon exitButtonBasicImage = new ImageIcon(Main.class.getResource("../images/exitButtonBasic.png"));
	private ImageIcon startButtonEnteredImage =new ImageIcon(Main.class.getResource("../images/startButtonEntered.png"));
	private ImageIcon startButtonBasicImage =new ImageIcon(Main.class.getResource("../images/startButtonBasic.png"));
	private ImageIcon quitButtonEnteredImage =new ImageIcon(Main.class.getResource("../images/quitButtonEntered.png"));
	private ImageIcon quitButtonBasicImage =new ImageIcon(Main.class.getResource("../images/quitButtonBasic.png"));
	
	private ImageIcon leftButtonBasicImage =new ImageIcon(Main.class.getResource("../images/leftButtonBasic.png"));
	private ImageIcon rightButtonBasicImage =new ImageIcon(Main.class.getResource("../images/rightButtonBasic.png"));
	private ImageIcon leftButtonEnteredImage =new ImageIcon(Main.class.getResource("../images/leftButtonEntered.png"));
	private ImageIcon rightButtonEnteredImage =new ImageIcon(Main.class.getResource("../images/rightButtonEntered.png"));
	
	private ImageIcon easyButtonBasicImage =new ImageIcon(Main.class.getResource("../images/easyButtonBasic.png"));
	private ImageIcon hardButtonBasicImage =new ImageIcon(Main.class.getResource("../images/hardButtonBasic.png"));
	private ImageIcon easyButtonEnteredImage =new ImageIcon(Main.class.getResource("../images/easyButtonEntered.png"));
	private ImageIcon hardButtonEnteredImage =new ImageIcon(Main.class.getResource("../images/hardButtonEntered.png"));
	
	private ImageIcon backButtonEnteredImage =new ImageIcon(Main.class.getResource("../images/backButtonEntered.png"));
	private ImageIcon backButtonBasicImage =new ImageIcon(Main.class.getResource("../images/backButtonEntered.png"));
	
	
	
	private Image  judgementLineImage = new ImageIcon(Main.class.getResource("../images/judgementLine.png")).getImage();
	private Image noteRouteImage = new ImageIcon(Main.class.getResource("../images/noteRoute.png")).getImage();
	private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("../images/noteRouteLine.png")).getImage();
	private Image noteBasicImage = new ImageIcon(Main.class.getResource("../images/noteBasic.png")).getImage();
	private Image  gameInfoImage = new ImageIcon(Main.class.getResource("../images/gameInfo.png")).getImage();
	private Image background = new ImageIcon(Main.class.getResource("../images/introbackGround.jpg")).getImage();
	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../images/menuBar.png")));
	
	private JButton exitButton = new JButton(exitButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton= new JButton(quitButtonBasicImage);
	private JButton leftButton= new JButton(leftButtonBasicImage);
	private JButton rightButton= new JButton(rightButtonBasicImage);
	private JButton easyButton= new JButton(easyButtonBasicImage);
	private JButton hardButton= new JButton(hardButtonBasicImage);
	private JButton backButton= new JButton(backButtonBasicImage);
	
	private int mouseX, mouseY;
	
	
	private boolean isMainScreen = false;//ó������ ����ȭ���� �ƴ� ����ȭ�� �̱� ������ false ,  
	private boolean isGameScreen =false;
	ArrayList<MusicTrack> musicTrackList = new ArrayList<MusicTrack>() ;
	private Image selectedImage ;
	private Image titleImage ;
	private Music selectedMusic = new Music("JP Cooper - In The Silence.mp3", false);
	Music introMusic = new Music("introMusic.mp3", true);
	private int nowSelected = 0; //ù������ �ǹ�  �� ���缱�õ� ���ǹ�ȣ ,�ε����� 0���ͽ��� 
	
	
	public MusicGame() {
		setUndecorated(true);// ����� �⺻ ���� �޴��ٰ������
		setTitle("Dynamic Beat");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
	 
 
		introMusic.start();
		
		musicTrackList.add(new MusicTrack("In The Silence Title Image.png","In The Silence Start Image.png","In The Silence Game Image.png","JP Cooper - In The Silence Selected.mp3","JP Cooper - In The Silence.mp3"));
		musicTrackList.add(new MusicTrack("Pink Sweat$ Title Image.png", "Pink Sweat Start Image.png","Pink Sweat Game Imgae.png","Pink Sweat$ - Honesty Selected.mp3","Pink Sweat$  - Honesty.mp3"));
		musicTrackList.add(new MusicTrack("Tango Title Image.png", "Tango Start Image.png","Tango Game Image.png","ABIR - Tango Selected.mp3","ABIR - Tango.mp3"));
		exitButton.setBounds(1245, 0,30, 30); 
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnterdImage);
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEenteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEenteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();
				try {
					Thread.sleep(1000);//����Ҹ��� ��� ���� ���ؼ�
				}catch(InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(exitButton);
		
		startButton.setBounds(40, 200,400, 100);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEenteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEenteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();
				introMusic.close();
			
				selectTrack(0);//��ó������ ù��°���� ���õǱⶫ�� �̰� �����Ŵ
				
			//// �Ʒ��� ���ӽ����̺�Ʈ ������ /////
				enterMain();
			}
		});
		add(startButton);
		
		
		quitButton.setBounds(40, 330, 400, 100);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEenteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEenteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();
				try {
					Thread.sleep(1000);//����Ҹ��� ��� ���� ���ؼ�
				}catch(InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(quitButton);
		
		leftButton.setVisible(false);//ó������ �Ⱥ��̰� ������ ���̰� �ϱ����ؼ� false �� ���� 
		leftButton.setBounds(140, 310, 60, 60);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonEnteredImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEenteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEenteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();
				
				//���� ��ư �̺�Ʈ  
				selectLeft();
			}
		});
		add(leftButton);
		
		rightButton.setVisible(false);//��ó���� ������ �ʴٰ� .�����ϱ��ư ������ ����ȭ�� �Ѿ������ ���ν�ũ���� ���ͼ� ���̱������.
		rightButton.setBounds(1080, 310, 60, 60);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonEnteredImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEenteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEenteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();
				
				//������ ��ư �̺�Ʈ  
				selectRight();
			}
		});
		add(rightButton);
		
		easyButton.setVisible(false);//��ó���� ������ �ʴٰ� .�����ϱ��ư ������ ����ȭ�� �Ѿ������ ���ν�ũ���� ���ͼ� ���̱������.
		easyButton.setBounds(375, 580, 250, 67);
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		easyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				easyButton.setIcon(easyButtonEnteredImage);
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEenteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEenteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				easyButton.setIcon(easyButtonBasicImage);
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();
				gameStart(nowSelected,"easy");
				
			}
		});
		add(easyButton);
		
		hardButton.setVisible(false);//��ó���� ������ �ʴٰ� .�����ϱ��ư ������ �� ��ȭ�� �Ѿ������ ���ν�ũ���� ���ͼ� ���̱������.
		hardButton.setBounds(655, 580, 250, 67);
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);
		hardButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hardButton.setIcon(hardButtonEnteredImage);
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEenteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEenteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				hardButton.setIcon(hardButtonBasicImage);
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();
				gameStart(nowSelected,"hard");
				
			}
		});
		add(hardButton);

		
		backButton.setVisible(false);//��ó���� ������ �ʴٰ� .�����ϱ��ư ������ ����ȭ�� �Ѿ������ ���ν�ũ���� ���ͼ� ���̱������.
		backButton.setBounds(20, 50, 60, 60);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(backButtonEnteredImage);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEenteredMusic = new Music("buttonEnteredMusic.mp3",false);
				buttonEenteredMusic.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backButtonBasicImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonPressedMusic = new Music("buttonPressedMusic.mp3",false);
				buttonPressedMusic.start();
				//�������� ���ư��� �̺�Ʈ
				backMain();
				
			}
		});
		add(backButton);
		
		
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getXOnScreen();
				setLocation(x-mouseX, y-mouseY);
			}
		});
		add(menuBar);
		
	
		
	
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D)screenGraphic);
		g.drawImage(screenImage, 0, 0, null);

	}

	private void screenDraw(Graphics2D g) {

		g.drawImage(background, 0, 0, null);// 0,0 ��ǥ , add �ȰԾƴ϶� ȭ�餷 ��������ִ� ���� g �� ���  
		if(isMainScreen) {
			g.drawImage(selectedImage,340, 100, null); 
			g.drawImage(titleImage,100,70, null);
			
		}
		
		if(isGameScreen) {
			g.drawImage(noteRouteImage,228,30,null);
			g.drawImage(noteRouteImage,332,30,null);
			g.drawImage(noteRouteImage,436,30,null);
			g.drawImage(noteRouteImage,540,30,null);
			g.drawImage(noteRouteImage,640,30,null);
			g.drawImage(noteRouteImage,744,30,null);
			g.drawImage(noteRouteImage,848,30,null);
			g.drawImage(noteRouteImage,952,30,null);
			g.drawImage(noteRouteLineImage,224,30,null);
			g.drawImage(noteRouteLineImage,328,30,null);
			g.drawImage(noteRouteLineImage,432,30,null);
			g.drawImage(noteRouteLineImage,536,30,null);
			g.drawImage(noteRouteLineImage,740,30,null);
			g.drawImage(noteRouteLineImage,844,30,null);
			g.drawImage(noteRouteLineImage,948,30,null);
			g.drawImage(noteRouteLineImage,1052,30,null);
			g.drawImage(noteBasicImage,228,120,null);
			g.drawImage(noteBasicImage,332,580,null);
			g.drawImage(noteBasicImage,436,500,null);
			g.drawImage(noteBasicImage,540,340,null);
			g.drawImage(noteBasicImage,640,340,null);
			g.drawImage(noteBasicImage,744,325,null);
			g.drawImage(noteBasicImage,848,305,null);
			g.drawImage(noteBasicImage,952,305,null);
			g.drawImage(gameInfoImage,0, 660, null); 
			g.drawImage(judgementLineImage,0, 580, null); 
			
			g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
			g.setColor(Color.WHITE);//��������ȭ�鿡�� �� ���� �ִºκ�
			g.setFont(new Font("Arial",Font.BOLD,30));
			g.drawString("JP Cooper - In The Silence", 20, 702);//������� ����Ҽ��ֵ��� ��.
			g.drawString("Easy",1190,702);
			g.setFont(new Font("Arial",Font.PLAIN,26));
			g.setColor(Color.WHITE);
			g.drawString("S",270,609);
			g.drawString("D",374,609);
			g.drawString("F",478,609);
			g.drawString("Space Bar",580,609);
			g.drawString("J",784,609);
			g.drawString("K",559,609);
			g.drawString("L",993,609);
			
			g.setColor(Color.LIGHT_GRAY);
			g.setFont(new Font("Elephant",Font.BOLD,30));
			g.drawString("000000",565,702);
		}
		paintComponents(g);// �޴��ٰ��� �� �׻� �����ϱ� ������ �ѹ�ư�̳� ������ �޴��ٿ� �����., add�� �߰��� �ֵ��� �����ִ� �κ��̰� 
		this.repaint();// ��üȭ�� �̹����� �ż������� �׷���.
	}
	
	public void selectTrack(int nowSelected) {
		if (selectedMusic!=null) {
			selectedMusic.close();
			titleImage =  new ImageIcon(Main.class.getResource("../images/" + musicTrackList.get(nowSelected).getTitleImage())).getImage();
			selectedImage =  new ImageIcon(Main.class.getResource("../images/"+ musicTrackList.get(nowSelected).getStartImage())).getImage();
			selectedMusic = new Music(musicTrackList.get(nowSelected).getStartMusic(),true);
			selectedMusic.start();
		}
	}
	
	public void selectLeft() {
		if(nowSelected == 0) {
			nowSelected = musicTrackList.size() -1;
		}else {
			nowSelected--;
		}
		selectTrack(nowSelected);
	}
	
	
	
	public void selectRight() {
		if(nowSelected == musicTrackList.size() -1) {//���������̶�� ù��°�� 
			nowSelected = 0;
		}else {
			nowSelected++;//�ƴ϶󤤸� �ô����ŤǤ���
		}
		selectTrack(nowSelected);
	}
	
	public void gameStart(int nowSelected, String difficulty) {
		if(selectedMusic != null) {
			selectedMusic.close();
			isMainScreen = false;
			leftButton.setVisible(false);
			rightButton.setVisible(false);
			easyButton.setVisible(false);
			hardButton.setVisible(false);
			background =  new ImageIcon(Main.class.getResource("../images/" + musicTrackList.get(nowSelected).getGameImage())).getImage();
			backButton.setVisible(true);
			
			isGameScreen = true;
		}
	}
	
	public void backMain() {
		isMainScreen =true;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		
		background =  new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
		backButton.setVisible(false);
		selectTrack(nowSelected);
		isGameScreen = false;
	}

	public void enterMain() {		
		startButton.setVisible(false);
		quitButton.setVisible(false);
		background =  new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
		isMainScreen = true;
		leftButton.setVisible(true);//����ȭ�鿡�� �¿� ��ư�� �������ϱ⶧���� true �� �ؾ���
		rightButton.setVisible(true);
		easyButton.setVisible(true);//
		hardButton.setVisible(true);
		isMainScreen = true;
		
		selectTrack(0);
	}
}