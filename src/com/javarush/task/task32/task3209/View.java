package com.javarush.task.task32.task3209;

import com.javarush.task.task32.task3209.listeners.FrameListener;
import com.javarush.task.task32.task3209.listeners.TabbedPaneChangeListener;
import com.javarush.task.task32.task3209.listeners.UndoListener;

import javax.swing.*;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View  extends JFrame implements ActionListener {

    private UndoManager undoManager = new UndoManager();
   private Controller controller;
   private JTabbedPane tabbedPane = new JTabbedPane();
   private  JTextPane htmlTextPane = new JTextPane();
   private  JEditorPane plainTextPane = new JEditorPane();

    private UndoListener undoListener = new UndoListener(undoManager);

    public View() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            ExceptionHandler.log(e);
        }

    }
    public  void undo(){
        try {
            undoManager.undo();
        } catch (CannotUndoException e){
            ExceptionHandler.log(e);
        }

    }
    public  void redo(){
        try {
            undoManager.redo();
        } catch (CannotRedoException e){
            ExceptionHandler.log(e);
        }
    }




    public void selectedTabChanged() {
        switch (tabbedPane.getSelectedIndex()) {
            case 0:
                controller.setPlainText(plainTextPane.getText());
                break;
            case 1:
                plainTextPane.setText(controller.getPlainText());
                break;
        }
        resetUndo();
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        String a = actionEvent.getActionCommand();
        if(a.equals("Новый")){
            controller.createNewDocument();
        } else if (a.equals("Открыть")){
            controller.openDocument();
        }else if (a.equals("Сохранить")){
            controller.saveDocument();
        } else if (a.equals("Сохранить как...")){
            controller.saveDocumentAs();
        } else if(a.equals("Выход")){
            controller.exit();
        } else if(a.equals("О программе")){
            this.showAbout();
        }
    }
    public void exit(){
     controller.exit();
    }
    public void init(){
initGui();
        FrameListener frameListener = new FrameListener(this);
        addWindowListener(frameListener);
        setVisible(true);
    }
    public void  initMenuBar(){
    JMenuBar jMenuBar = new JMenuBar();
    MenuHelper.initFileMenu(this,jMenuBar);
    MenuHelper.initEditMenu(this,jMenuBar);
MenuHelper.initStyleMenu(this,jMenuBar);
MenuHelper.initAlignMenu(this,jMenuBar);
MenuHelper.initColorMenu(this,jMenuBar);
        MenuHelper.initFontMenu(this, jMenuBar);
        MenuHelper.initHelpMenu(this, jMenuBar);
getContentPane().add(jMenuBar,BorderLayout.NORTH);
    }
    public void  initEditor(){
        htmlTextPane.setContentType("text/html");

        tabbedPane.addTab("HTML", new JScrollPane(htmlTextPane));

        tabbedPane.addTab("Текст", new JScrollPane(plainTextPane));

        tabbedPane.setPreferredSize(new Dimension(100, 100));
        tabbedPane.addChangeListener(new TabbedPaneChangeListener(this));
        this.getContentPane().add(tabbedPane, BorderLayout.CENTER);
    }
   public void initGui(){
        initMenuBar();
        initEditor();
        pack();
   }

    public boolean canUndo() {
          return undoManager.canUndo();
    }

    //Проверка возможности перейти на действие вперед
    public boolean canRedo() {
        return undoManager.canRedo();
    }
   public  void resetUndo(){
        undoManager.discardAllEdits();
    }

    public UndoListener getUndoListener() {
        return undoListener;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }
    public boolean isHtmlTabSelected(){
        return tabbedPane.getSelectedIndex() == 0;

    }
    public void selectHtmlTab(){
tabbedPane.setSelectedIndex(0);
resetUndo();
    }
   public void update(){
    htmlTextPane.setDocument( controller.getDocument());
   }
   public void showAbout(){
        JOptionPane.showMessageDialog(getContentPane(), "LOL","LOL",JOptionPane.INFORMATION_MESSAGE);
   }

}
