package com.example2;

import java.io.*;
import java.net.URISyntaxException;

import org.gnome.gdk.Event;
import org.gnome.gtk.*;

public class UselessGUIApp{
    private String strBuffer = "";
    private UselessGUIApp() throws URISyntaxException{
        final Window mainWindow;
        mainWindow = new Window();
        VBox vbox = new VBox(false, 1);
               
        TextView view = new TextView();
        view.setSizeRequest(200, 300);
        
        TextTag sansMono = new TextTag();
        sansMono.setFamily("DejaVu Sans Mono, 12");

        TextTag sans = new TextTag();
        sans.setFamily("DejaVu Sans, 25");
        sans.setForeground("green");
        
        final TextBuffer buffer = new TextBuffer();
        TextIter pointer = buffer.getIterStart();
        
        buffer.insert(pointer, "Some text, ");
        buffer.insert(pointer, "another text, ", sansMono);
        buffer.insert(pointer, "one more another text", sans);
        
        view.setBuffer(buffer);
        view.setWrapMode(WrapMode.WORD);
        
        vbox.add(view);
        Button copyButton = new Button("Copy");
        copyButton.connect(new Button.Clicked() {
            @Override
            public void onClicked(Button source) {
                strBuffer = buffer.getText(buffer.getSelectionBound().getIter(), 
					buffer.getInsert().getIter(), true);
            }
        });
        vbox.add(copyButton);
        
        Button pasteButton = new Button("Paste");
        pasteButton.connect(new Button.Clicked() {
            @Override
            public void onClicked(Button source) {
                
              MessageDialog dlg = new MessageDialog(mainWindow, true, 
				MessageType.INFO, ButtonsType.OK_CANCEL, 
				"Are you sure you want to paste text from buffer?");
                ResponseType choice = dlg.run();
                if (choice == ResponseType.OK) {
                    buffer.insert(buffer.getInsert().getIter(), strBuffer);
                }else{
                    //nothing
                }
                dlg.hide();
            }
        });
        vbox.add(pasteButton);
        
        Button saveButton = new Button("Save");
        saveButton.connect(new Button.Clicked() {
            @Override
            public void onClicked(Button source) {
                FileChooserDialog fd = new FileChooserDialog("save me!!", mainWindow, 
					FileChooserAction.SAVE);
                
                ResponseType choice = fd.run();
                if (choice == ResponseType.OK) {
                    File saveFile = new File(fd.getFilename());
                    PrintWriter out = null;
                    try {
                        out = new PrintWriter(saveFile);
                        out.write(buffer.getText());
                        out.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }else{
                    //nothing
                }
                fd.hide();
            }
        });
        vbox.add(saveButton);
        
        mainWindow.add(vbox);
        mainWindow.showAll();
        mainWindow.connect(new Window.DeleteEvent() {
            public boolean onDeleteEvent(Widget source, Event event) {
                Gtk.mainQuit();
                return false;
            }
        });
    }

    public static void main(String[] args) throws URISyntaxException {
        Gtk.init(args);
        
        new UselessGUIApp();
        
        Gtk.main();
    }
}
