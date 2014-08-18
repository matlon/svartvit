package mod.svartvit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class Ball extends View
{
	
	private float sx, sy, vx, vy, ax, ay, br, currentX, currentY, previousX, previousY;
	private Paint paint = new Paint();
	private Paint conturePaint = new Paint();
	
	public Ball(Context context) 
	{
		super(context);
		init();
	}
	public Ball(Context context, AttributeSet attrs) 
	{
		super(context, attrs);
		init();
	}
	
	private void init()
	{
		paint.setColor(Color.WHITE);
		paint.setStyle(Style.FILL);
		conturePaint.setColor(Color.BLACK);
		conturePaint.setStyle(Style.STROKE);
		sx=getWidth()/2;
		sy=getHeight()/2;
		br=20;
	}
	
	@Override
	protected void onDraw(Canvas canvas)
	{
		canvas.drawCircle(sx, sy, br, paint);
		canvas.drawCircle(sx, sy, br, conturePaint);
	}
	
	public boolean onTouchEvent(MotionEvent e)
	{
		currentX=e.getX();
		currentY=e.getY();
		switch (e.getAction()){
		case MotionEvent.ACTION_MOVE:
			ax = (currentX - sx)/500000;
			ay = (currentY - sy)/500000;
			return true;
		case MotionEvent.ACTION_DOWN:
			ax = (currentX - sx)/500000;
			ay = (currentY - sy)/500000;
			return true;
		case MotionEvent.ACTION_UP:
			ax = 0;
			ay = 0;
			return true;
		}
		return true;
	}

	//position
	public float getSX()
	{
		return sx;
	}
	public float getSY()
	{
		return sy;
	}
	public void setPos(float sx, float sy){
		this.sx = sx;
		this.sy = sy;
		invalidate();
	}
	
	//hastighet
	public float getVX()
	{
		return vx;
	}
	public float getVY()
	{
		return vy;
	}
	public void setVel(float vx, float vy){
		this.vx = vx;
		this.vy = vy;
	}
	
	//acceleration
	public float getAX()
	{
		return ax;
	}
	public float getAY()
	{
		return ay;
	}
	public void setBallPos(float x, float y)
	{
		sx=x;
		sy=y;
	}
}
