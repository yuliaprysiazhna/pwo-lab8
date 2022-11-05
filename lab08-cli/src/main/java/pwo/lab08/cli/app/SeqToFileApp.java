/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pwo.lab08.cli.app;


import pwo.utils.SequenceTools;

import java.nio.file.Paths;
import java.nio.file.InvalidPathException;
import pwo.lab08.engine.seq.SeqType;

class SeqToFileApp {

    protected SeqType seqType = null;
    protected Integer from = null, to = null;
    protected String fileName = null;

    protected boolean getArgs(String[] args) {
        try {
            seqType = SeqType.fromString(args[0]);
            from = Integer.parseInt(args[1]);
            to = Integer.parseInt(args[2]);
            fileName = args[3];
        } catch (ArrayIndexOutOfBoundsException
                | NumberFormatException ex) {
            return false;
        }

        try {
            Paths.get(fileName);
        } catch (InvalidPathException ex) {
            return false;
        }

        return seqType != null && from >= 0 && to >= 0;
    }

    protected boolean writeSeqq() {
        return SequenceTools.writeToFile(seqType.getGenerator(),
                from, to, fileName);
    }

    public void run(String[] args) {
        System.out.println("Sequence to file CLI app");

        if (!getArgs(args)) {
            System.out.println("!Illegal arguments\n"
                    + "Legal usage: seqName from to fileName");
            return;
        }

        if (!writeSeqq()) {
            System.out.println("!Write to the file: "
                    + fileName + " FAILED");
            return;
        }

        System.out.println("Results write to " + fileName);
    }
}