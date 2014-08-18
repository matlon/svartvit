package mod.svartvit;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;

public class MainActivity extends Activity {

	private Ball ball;
	private int dt = 10;
	private float ax, ay, vx, vy, sx, sy;
	Handler mHandler = new Handler();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ball = (Ball) findViewById(R.id.ball);
		
		new Thread(new Runnable() {
				@Override
				public void run() {
					while (true) {
						try {
							Thread.sleep(dt);
							mHandler.post(new Runnable() {
								@Override
								public void run() {
									
									/*
									sx = ball.getSX() + ball.getVX() * dt;
									sy = ball.getSY() + ball.getVY() * dt;
									vx = ball.getVX() + ball.getAX() * dt;
									vy = ball.getVY() + ball.getAY() * dt;
									*/
									
									// Num-metod Euler
									//         |--------------- SX -------------|-------------- SY ---------------|
									ball.setPos(ball.getSX() + ball.getVX() * dt, ball.getSY() + ball.getVY() * dt);
									//         |--------------- VX -------------|-------------- VY ---------------|
									ball.setVel(ball.getVX() + ball.getAX() * dt, ball.getVY() + ball.getAY() * dt);
								}
							});
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			}).start();
	}
}
