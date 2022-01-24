/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tfm.model.nrt;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import tfm.Refs;
import tfm.utils.Combinator;
import tfm.model.pcst.PCSet;

/**
 *
 * @author william
 */
public class Tonnetz {

    private List<PCSNode> nodes;

    public Tonnetz() {
        nodes = new ArrayList<>();

        add(new PCSNode(new PCSet(0, 3, 7)));
        add(new PCSNode(new PCSet(0, 4, 7)));
        add(new PCSNode(new PCSet(0, 4, 9)));
        add(new PCSNode(new PCSet(0, 5, 9)));
        add(new PCSNode(new PCSet(0, 5, 8)));
        add(new PCSNode(new PCSet(0, 3, 8)));
        //
        add(new PCSNode(new PCSet(1, 4, 8)));
        add(new PCSNode(new PCSet(1, 5, 8)));
        add(new PCSNode(new PCSet(1, 5, 10)));
        add(new PCSNode(new PCSet(1, 6, 10)));
        add(new PCSNode(new PCSet(1, 6, 9)));
        add(new PCSNode(new PCSet(1, 4, 9)));
        //
        add(new PCSNode(new PCSet(2, 5, 9)));
        add(new PCSNode(new PCSet(2, 6, 9)));
        add(new PCSNode(new PCSet(2, 6, 11)));
        add(new PCSNode(new PCSet(2, 7, 11)));
        add(new PCSNode(new PCSet(2, 7, 10)));
        add(new PCSNode(new PCSet(2, 5, 10)));
        //
        add(new PCSNode(new PCSet(3, 6, 10)));
        add(new PCSNode(new PCSet(3, 7, 10)));
        add(new PCSNode(new PCSet(3, 8, 11)));
        add(new PCSNode(new PCSet(3, 6, 11)));
        //
        add(new PCSNode(new PCSet(4, 7, 11)));
        add(new PCSNode(new PCSet(4, 8, 11)));

        connect();
    }

    private void add(PCSNode node) {
        boolean exists = false;
        //avoid duplicates
        for (PCSNode n : nodes) {
            if (node.equals(n)) {
                exists = true;
                System.out.println("Warning: node " + n + " exists");
                break;
            }
        }

        if (!exists) {
            nodes.add(node);
        }
    }

    private void connect() {
        //connect
        getNode(0, 3, 7).setL(getNode(7, 3, 10)).setR(getNode(0, 3, 8)).setP(getNode(0, 4, 7));
        getNode(0, 4, 7).setL(getNode(0, 4, 9)).setR(getNode(4, 11, 7)).setP(getNode(0, 3, 7));
        getNode(0, 4, 9).setL(getNode(0, 4, 7)).setR(getNode(0, 9, 5)).setP(getNode(1, 9, 4));
        getNode(0, 5, 9).setL(getNode(2, 5, 9)).setR(getNode(0, 4, 9)).setP(getNode(0, 5, 8));
        getNode(0, 5, 8).setL(getNode(0, 3, 8)).setR(getNode(1, 5, 8)).setP(getNode(0, 5, 9));
        getNode(0, 3, 8).setL(getNode(0, 5, 8)).setR(getNode(0, 3, 7)).setP(getNode(8, 3, 11));
        //
        getNode(1, 4, 8).setL(getNode(8, 4, 11)).setR(getNode(1, 4, 9)).setP(getNode(1, 5, 8));
        getNode(1, 5, 8).setL(getNode(1, 5, 10)).setR(getNode(0, 5, 8)).setP(getNode(1, 4, 8));
        getNode(1, 5, 10).setL(getNode(1, 5, 8)).setR(getNode(1, 6, 10)).setP(getNode(2, 5, 10));
        getNode(1, 6, 10).setL(getNode(3, 6, 10)).setR(getNode(1, 5, 10)).setP(getNode(1, 6, 9));
        getNode(1, 6, 9).setL(getNode(1, 4, 9)).setR(getNode(2, 6, 9)).setP(getNode(1, 6, 10));
        getNode(1, 4, 9).setL(getNode(1, 6, 9)).setR(getNode(1, 4, 8)).setP(getNode(0, 4, 9));
        //
        getNode(2, 5, 9).setL(getNode(0, 5, 9)).setR(getNode(2, 5, 10)).setP(getNode(2, 6, 9));
        getNode(2, 6, 9).setL(getNode(2, 6, 11)).setR(getNode(1, 6, 9)).setP(getNode(2, 5, 9));
        getNode(2, 6, 11).setL(getNode(2, 6, 9)).setR(getNode(2, 7, 11)).setP(getNode(3, 6, 11));
        getNode(2, 7, 11).setL(getNode(4, 7, 11)).setR(getNode(2, 6, 11)).setP(getNode(2, 7, 10));
        getNode(2, 7, 10).setL(getNode(2, 5, 10)).setR(getNode(3, 7, 10)).setP(getNode(2, 7, 11));
        getNode(2, 5, 10).setL(getNode(2, 7, 10)).setR(getNode(2, 5, 9)).setP(getNode(1, 5, 10));
        //
        getNode(3, 6, 10).setL(getNode(1, 6, 10)).setR(getNode(3, 6, 11)).setP(getNode(3, 7, 10));
        getNode(3, 7, 10).setL(getNode(0, 3, 7)).setR(getNode(2, 7, 10)).setP(getNode(3, 6, 10));
        getNode(3, 8, 11).setL(getNode(3, 6, 11)).setR(getNode(4, 8, 11)).setP(getNode(0, 3, 8));
        getNode(3, 6, 11).setL(getNode(3, 8, 11)).setR(getNode(3, 6, 10)).setP(getNode(2, 6, 11));
        //
        getNode(4, 7, 11).setL(getNode(2, 7, 11)).setR(getNode(0, 4, 7)).setP(getNode(4, 8, 11));
        getNode(4, 8, 11).setL(getNode(1, 4, 8)).setR(getNode(3, 8, 11)).setP(getNode(4, 7, 11));

    }

    public PCSNode getNode(int pitchClass1, int pitchClass2, int pitchClass3) {
        PCSNode target = new PCSNode(new PCSet(pitchClass1, pitchClass2, pitchClass3));

        PCSNode found = null;

        for (PCSNode node : nodes) {
            if (target.equals(node)) {
                found = node;
                break;
            }
        }

        return found;
    }

    public PCSNode applySingle(PCSNode node, List<String> operations) {
        PCSNode n = node;

        for (String s : operations) {
            for (Character c : s.toCharArray()) {
                n = apply(n, c);
            }
        }

        return n;
    }

    public List<PCSNode> applyAll(PCSNode node, List<String> operations) {
        List<PCSNode> nods = new ArrayList<>();
        PCSNode n = node;

        for (String s : operations) {
            for (Character c : s.toCharArray()) {
                n = apply(n, c);
                nods.add(n);
            }
        }

        return nods;
    }

    private PCSNode apply(PCSNode node, Character op) {
        PCSNode n = null;

        if (op.equals(Operations.T)) {
            n = node;
        } else if (op.equals(Operations.L)) {
            n = node.getL();
        } else if (op.equals(Operations.R)) {
            n = node.getR();
        } else if (op.equals(Operations.P)) {
            n = node.getP();
        } else {
            System.out.println("Warning operation " + op + " not known.");
        }

        return n;
    }

    public void print() {
        for (PCSNode node : nodes) {
            System.out.println(node.getSet());
        }
        System.out.println("Total: " + nodes.size());
    }

    public void check() {
        for (PCSNode node : nodes) {
            try {
                System.out.print("Actual:" + node);
                System.out.print(" L:" + node.getL());
                System.out.print(" R:" + node.getR());
                System.out.print(" P:" + node.getP());
                System.out.print(" T:" + node.getT());
                System.out.print(" PP:" + node.getP().getP());
                System.out.print(" RR:" + node.getR().getR());
                System.out.print(" LL:" + node.getL().getL());
                System.out.print(" PL:" + node.getP().getL());
                System.out.print(" PR:" + node.getP().getR());
                System.out.print(" LP:" + node.getL().getP());
                System.out.print(" LR:" + node.getL().getR());
                System.out.print(" RL:" + node.getR().getL());
                System.out.println(" RP:" + node.getR().getP());
            } catch (Exception e) {
                System.out.println("\nError in tonnetz");
            }
        }
    }

    public String getPath(PCSNode from, PCSNode to) {
        String path = "";
        boolean found = false;
        int size = 1;

        Combinator c = new Combinator();

        //all posibilites
        while (!found) {
            c.getCombinations(size, "");

            List<String> operations = c.getPaths();

            for (String op : operations) {
                if (applySingle(from, split(op)).equals(to)) {
                    found = true;
                    path = op;
                    break;
                }
            }

            size++;
        }

        return path;
    }

    /**
     * @return the nodes
     */
    public List<PCSNode> getNodes() {
        return nodes;
    }

    public List<String> findTransformations(List<PCSet> sets) {
        List<String> transf = new ArrayList<>();

        for (int i = 0; i < sets.size() - 1; i++) {
            PCSet setF = sets.get(i);
            PCSet setT = sets.get(i + 1);
            PCSNode from = getNode(setF.getClasses().get(0), setF.getClasses().get(1), setF.getClasses().get(2));
            PCSNode to = getNode(setT.getClasses().get(0), setT.getClasses().get(1), setT.getClasses().get(2));

            transf.add(getPath(from, to));
        }

        return transf;
    }

    private List<String> split(String op) {
        List<String> ops = new ArrayList<>();

        for (Character c : op.toCharArray()) {
            ops.add(String.valueOf(c));
        }

        return ops;
    }

    public List<PCSNode> generateNodes(List<String> ops) {
        List<PCSNode> nods = new ArrayList<>();
        Random r = new Random();

        //start in random node
        PCSNode n = nodes.get(r.nextInt(nodes.size()));
        nods.add(n);

        for (String o : ops) {
            n = applySingle(n, split(o));
            nods.add(n);
        }

        return nods;
    }
}
