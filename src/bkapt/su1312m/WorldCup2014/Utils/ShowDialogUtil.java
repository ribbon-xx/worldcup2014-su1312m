package bkapt.su1312m.WorldCup2014.Utils;

import bkapt.su1312m.WorldCup2014.PagerFrafmentActivity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

public class ShowDialogUtil {

	private static AlertDialog alertDialog;

	public static void showAlertNetwork(final Context context) {
		alertDialog = new AlertDialog.Builder(context)
				.setTitle("Lỗi kết nối")
				.setMessage("Hãy kết nối internet và thử lại sau!")
				.setPositiveButton(android.R.string.yes,
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog,
									int which) {
								alertDialog.dismiss();
								((PagerFrafmentActivity)context).finish();
							}
						}).setIcon(android.R.drawable.ic_dialog_alert).create();
		alertDialog.show();
	}

}
