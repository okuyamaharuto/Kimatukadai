import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class MazeFrame extends MyFrame {
	//GameFrameの代わり
	public void run() {
		
		
		
		Restart re = new Restart();
		
		
		Createouterwall();
		
		Makepillars();
		
		Makemaze();
		
		MakeSG();
		
		addKeyListener(re);
		
	
}
	
	
	
	
	public void Createouterwall(){
		
		
		for (int i = 0; i <=64; i++) {
			if(i < 17) {
				MazeWorld.outerwall = new Outerwall(50, 60 + 20 * (i - 1), 20, 20);
				MazeWorld.outerwall.draw(this);
				}
			else if(i<33) {
				MazeWorld.outerwall = new Outerwall(70 + 20 * (i-17), 360, 20, 20);
				MazeWorld.outerwall.draw(this);
			    }
			else if(i<50) {
				MazeWorld.outerwall = new Outerwall(370, 360-20 * (i-33), 20, 20);
				MazeWorld.outerwall.draw(this);
			    }
			else {
				MazeWorld.outerwall = new Outerwall(370-20 * (i-49), 40, 20, 20);
				MazeWorld.outerwall.draw(this);
			    }
			
		}
}
	
	
	public void Makepillars() {
		
		int[][] pillars;
		pillars = new int[15][15];
		
	    for(int i = 1; i<15;i+=2) {      //柱生成
		     for(int j= 1; j<15; j+=2) {
			     pillars[i][j] = 1;
		     }
	     }
	     for(int n = 0;n<15;n++) {
	    	 
    	      for(int m= 0;m<15;m++) {
    	    	  
    		      if(pillars[n][m] == 1) {
    			      int xx = n*20+70;
    			      int yy = m*20+60;
    			      MazeWorld.outerwall = new Outerwall(xx,yy, 20, 20);
 				      MazeWorld.outerwall.draw(this);
 				      sleep(0.01);
    		       }
    		      
    	       }
    	      
           }
	}
	
	
	
	public void Makemaze() {
	     int[][] kabe;
	     kabe = new int[15][15];
	
	
	     for(int i=0; i<15; i++) {     //初期化
		     for(int j=0; j<15; j++) {
		         kabe[i][j]=0;
		     }
	     }
	
	
	
	
	for(int i = 1; i<15; i+=2) {
		for(int j = 1;j<15;j+=2) {
			Random houkou = new Random();
			int muki = houkou.nextInt(4);
			
//１行目の場合
		if(i == 1) {               
			if(muki == 0) {        //up
				kabe[i-1][j] = 1;
			}
			else if(muki == 1) {   //down
				if(kabe[i+1][j] != 1) {
					kabe[i+1][j] = 1;
				}
				else {
					j-=2;
				}
			}
			else if(muki == 2) {   //left
				if(kabe[i][j-1]!= 1) {
					kabe[i][j-1] = 1;
				}
				else {
					j-=2;
				}
			}
			else {                 //right
				if(kabe[i][j+1]!=1) {
					kabe[i][j+1] = 1;
				}
				else {
					j-=2;
				}
			}
		 }
//２行目以降		
			else {                

				if(muki == 1) {   //down
					if(kabe[i+1][j] != 1) {
						kabe[i+1][j] = 1;
					}
					else {
						j-=2;
					}
				}
				else if(muki == 2) {   //left
					if(kabe[i][j-1] != 1) {
						kabe[i][j-1] = 1;
					}
					else {
						j-=2;
					}
				}
				else {                 //right
					if(kabe[i][j+1] !=1) {
						kabe[i][j+1] = 1;
					}
					else {
						j-=2;
					}
				}
			}
		}
	
	
	//描写する処理
		
     for(int n = 0;n<15;n++) {
    	 for(int m= 0;m<15;m++) {
    		 if(kabe[n][m] == 1) {
    			 int xx = n*20+70;
    			 int yy = m*20+60;
    			 MazeWorld.outerwall = new Outerwall(xx,yy, 20, 20);
 				MazeWorld.outerwall.draw(this);
 				sleep(0.01);
    		 }
    	 }
     }
	}
	}
	
	public void MakeSG() {
		MazeWorld.goal = new Goal(350,340,20,20);
		MazeWorld.goal.draw(this);
		sleep(1);
		MazeWorld.start = new Start(70,60,20,20);
		MazeWorld.start.draw(this);
	}
	
	
	
	
	public class Restart implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			if(e.getKeyCode() == KeyEvent.VK_SPACE) {
				   clear();
				   run();
				}
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO 自動生成されたメソッド・スタブ
			
		}
	}
	
}

