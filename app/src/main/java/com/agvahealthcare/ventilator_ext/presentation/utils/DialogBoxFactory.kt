package com.agvahealthcare.ventilator_ext.presentation.utils

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Handler
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.constraintlayout.widget.ConstraintLayout
import com.agvahealthcare.ventilator_ext.R
import com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnStandbyCLickListener
import com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.OnTherapyEndListener
import com.agvahealthcare.ventilator_ext.presentation.ui.interfaces.SimpleCallbackListener

/**
 * Created by MOHIT MALHOTRA on 14-09-2018.
 */
object DialogBoxFactory {
    private var dialogView: AlertDialog? = null
    private val handler = Handler()
    fun dismissDialogs() {
        if (dialogView != null) {
            dialogView!!.dismiss()
        }
    }
    fun showtherapyEndDialog(msg: String?, ctx: Context?,onClick: OnTherapyEndListener): AlertDialog {
        val view: View =
            LayoutInflater.from(ctx).inflate(R.layout.standby_confirmation_layout, null, false)

        val btnCancel = view.findViewById<ConstraintLayout>(R.id.cancel_standby)
        val btnContinue = view.findViewById<ConstraintLayout>(R.id.continue_standy)
        val dialogMessage = view.findViewById<TextView>(R.id.txtMsg)
        dialogMessage.text = msg
        val dialog = AlertDialog.Builder(
            ctx!!
        ).setView(view).create()
        dialog.setCancelable(true)

        btnContinue.setOnClickListener {
            onClick.onTherapyEnd()
            dialog.cancel()
        }
        btnCancel.setOnClickListener {
            dialog.cancel()
        }

        setDialogView(dialog, true)
        dialog.show()
        return dialog
    }


    fun showStandbyDialog(msg: String?, ctx: Context?,onClick: OnStandbyCLickListener): AlertDialog {
        val view: View =
            LayoutInflater.from(ctx).inflate(R.layout.standby_confirmation_layout, null, false)

        val btnCancel = view.findViewById<ConstraintLayout>(R.id.cancel_standby)
        val btnContinue = view.findViewById<ConstraintLayout>(R.id.continue_standy)
        val dialogMessage = view.findViewById<TextView>(R.id.txtMsg)
        dialogMessage.text = msg
        val dialog = AlertDialog.Builder(
            ctx!!
        ).setView(view).create()
        dialog.setCancelable(true)

        btnContinue.setOnClickListener {
            onClick.onStandby()
            dialog.cancel()
        }
        btnCancel.setOnClickListener {
            dialog.cancel()
        }

        setDialogView(dialog, true)
        dialog.show()
        return dialog
    }

    // created by Masoom 6 march 2023
    //    public static void showGraphChangeDialog(Context ctx, String graphType , ChangeGraphListener click) {
    //
    //        View view = LayoutInflater.from(ctx).inflate(R.layout.change_graph_type_layout, null, false);
    //        AlertDialog dialog = new AlertDialog.Builder(ctx).setView(view).create();
    //
    //        TextView tvPressureGraph = view.findViewById(R.id.tvPressureGraph);
    //        TextView tvVolumeGraph = view.findViewById(R.id.tvVolumeGraph);
    //        TextView tvFlowGraph = view.findViewById(R.id.tvFlowGraph);
    //
    //
    //        tvPressureGraph.setOnClickListener(v ->{
    //            click.setGraphType(graphType);
    //            dialog.cancel();
    //        });
    //
    //        tvVolumeGraph.setOnClickListener(v ->{
    //            click.setGraphType(graphType);
    //            dialog.cancel();
    //        });
    //
    //        tvFlowGraph.setOnClickListener(v ->{
    //            click.setGraphType(graphType);
    //            dialog.cancel();
    //        });
    //
    //
    //        dialog.show();
    //        setNeonateDialogView(dialog);
    //    }

    fun showDialog(
        ctx: Context?,
        title: String?,
        message: String?,
        listener: SimpleCallbackListener?
    ): AlertDialog? {
        return showDialog(ctx, title, message, null, listener)
    }

    // created by Masoom 6 march 2023
//    public static void showGraphChangeDialog(Context ctx, String graphType , ChangeGraphListener click) {
//
//        View view = LayoutInflater.from(ctx).inflate(R.layout.change_graph_type_layout, null, false);
//        AlertDialog dialog = new AlertDialog.Builder(ctx).setView(view).create();
//
//        TextView tvPressureGraph = view.findViewById(R.id.tvPressureGraph);
//        TextView tvVolumeGraph = view.findViewById(R.id.tvVolumeGraph);
//        TextView tvFlowGraph = view.findViewById(R.id.tvFlowGraph);
//
//
//        tvPressureGraph.setOnClickListener(v ->{
//            click.setGraphType(graphType);
//            dialog.cancel();
//        });
//
//        tvVolumeGraph.setOnClickListener(v ->{
//            click.setGraphType(graphType);
//            dialog.cancel();
//        });
//
//        tvFlowGraph.setOnClickListener(v ->{
//            click.setGraphType(graphType);
//            dialog.cancel();
//        });
//
//
//        dialog.show();
//        setNeonateDialogView(dialog);
//    }

    // created by Masoom 6 march 2023
    //    public static void showGraphChangeDialog(Context ctx, String graphType , ChangeGraphListener click) {
    //
    //        View view = LayoutInflater.from(ctx).inflate(R.layout.change_graph_type_layout, null, false);
    //        AlertDialog dialog = new AlertDialog.Builder(ctx).setView(view).create();
    //
    //        TextView tvPressureGraph = view.findViewById(R.id.tvPressureGraph);
    //        TextView tvVolumeGraph = view.findViewById(R.id.tvVolumeGraph);
    //        TextView tvFlowGraph = view.findViewById(R.id.tvFlowGraph);
    //
    //
    //        tvPressureGraph.setOnClickListener(v ->{
    //            click.setGraphType(graphType);
    //            dialog.cancel();
    //        });
    //
    //        tvVolumeGraph.setOnClickListener(v ->{
    //            click.setGraphType(graphType);
    //            dialog.cancel();
    //        });
    //
    //        tvFlowGraph.setOnClickListener(v ->{
    //            click.setGraphType(graphType);
    //            dialog.cancel();
    //        });
    //
    //
    //        dialog.show();
    //        setNeonateDialogView(dialog);
    //    }
    fun showDialog(
        ctx: Context?,
        title: String?,
        message: String?,
        btnText: String?,
        clickListener: SimpleCallbackListener?
    ): AlertDialog? {
        val view: View = LayoutInflater.from(ctx).inflate(R.layout.layout_design_alert, null, false)
        val tvTitle = view.findViewById<TextView>(R.id.tvHead)
        val tvMsg = view.findViewById<TextView>(R.id.tvDesc)
        val btnOk = view.findViewById<Button>(R.id.btnOk)
        if (title != null && !title.isEmpty()) tvTitle.text = title
        if (message != null && !message.isEmpty()) tvMsg.text = message
        if (btnText != null && !btnText.isEmpty()) btnOk.text = btnText
        val dialog = AlertDialog.Builder(ctx!!).setView(view).create()
        dialog.setCancelable(false)
        btnOk.setOnClickListener { v: View? ->
            if (clickListener != null) clickListener.doAction()
            dialog.cancel()
        }
        setDialogView(dialog, false)
        dialog.show()
        return dialog
    }


    private fun setDialogView(dialogView: AlertDialog, status: Boolean) {
        DialogBoxFactory.dialogView = dialogView
        // to make the window background transparent
        if (dialogView.window != null) dialogView.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        dialogView.window?.clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND)
        dialogView.window?.attributes?.let {
            val wmlp = it
            if (status) {
                wmlp.gravity = Gravity.BOTTOM or Gravity.START
            } else {
                wmlp.gravity = Gravity.BOTTOM or Gravity.CENTER
            }
            wmlp.height = 500
            wmlp.width = 200
            wmlp.dimAmount = 0.7f
            wmlp.screenBrightness = 10.0f
            wmlp.x = 350 //x position
            wmlp.y = 300 //y position
            dialogView.window?.attributes = wmlp
        }

    }
}