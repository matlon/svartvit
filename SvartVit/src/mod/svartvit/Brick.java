package mod.svartvit;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import mod.svartvit.R;

public class Brick extends View 
{

	private Paint paint = new Paint();
	private boolean isWhite = false;
	private int force;
	
	public Brick(Context context) 
	{
		super(context);
		paint.setStyle(Style.FILL);
	}

	public Brick(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		init(attrs);
		paint.setStyle(Style.FILL);
	}
	
	private void init(AttributeSet attrs)
	{
		TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.Brick);
		isWhite = a.getBoolean(R.styleable.Brick_isWhite, false);
		force = a.getInteger(R.styleable.Brick_force, 0);
		a.recycle();
	}
	

	@Override
	protected void onDraw(Canvas canvas)
	{
		if(isWhite)
		{
			paint.setColor(Color.WHITE);
		} else {
			paint.setColor(Color.BLACK);
		}
		canvas.drawRect(0, 0, getWidth(), getHeight(), paint);
	}
	
	/**
	 * 
	 * @param isWhite true -> the color is white, else black.
	 */
	public void setColor(boolean isWhite)
	{
		this.isWhite = isWhite;
		invalidate();
	}
	
	/**
	 * 
	 * @return true means white, false means black.
	 */
	public boolean getColor()
	{
		return isWhite;
	}
}
