package cn.iolove.lui.widget;

import cn.iolove.lui.context.RuntimeContext;
import cn.iolove.lui.model.ButtonModel;
import cn.iolove.lui.model.EditTextModel;
import cn.iolove.lui.model.UIModel;
import android.graphics.Color;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditTextWidget extends AbstractWidget {

	private EditText et;
	public EditTextWidget(UIModel m) {
		super(m);
		et = new EditText(RuntimeContext.getInstance().rl.getActivityContext());
		loadModel();
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getInnerView() {
		// TODO Auto-generated method stub
		return et;
	}

	@Override
	protected void loadModel() {
		WidgetUtils.loadModel(model, this);
		
		final EditTextModel bm = (EditTextModel)model;
		String str = ((EditTextModel)model).text;

		if(str!=null)
		{
			et.setText(str);
			
		}
		
		et.setTextColor(Color.parseColor(((EditTextModel)model).textcolor));
		et.setTextSize(TypedValue.COMPLEX_UNIT_DIP, bm.fontsize);
		if(bm.type.equals("password"))
		{
			
		et.setInputType(InputType.TYPE_CLASS_TEXT|InputType.TYPE_TEXT_VARIATION_PASSWORD);
		}
		et.addTextChangedListener(new TextWatcher() {
			
			@Override
			public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void afterTextChanged(Editable arg0) {
				bm.text = et.getText().toString();
				
				
			}
		});
		super.loadModel();
		reloadBackground(et);
		// TODO Auto-generated method stub

	}

	@Override
	public void Ondestroy() {
		// TODO Auto-generated method stub
		et.setBackgroundDrawable(null);
		et=null;
		
	}

}
