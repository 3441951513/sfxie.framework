package com.sfxie.algorithm.tree.btree;

import java.util.*;

/**
 * @author 
 * @version 1.0
 */
@SuppressWarnings("rawtypes")
public class BTree implements IBTree
{
    /**
     * Attributes
     */
    private static final long serialVersionUID = 1L;
    private BTreeNode root;
    private int order;
    
    /**
     * Constructor
     */
    public BTree(int order)
    {
        this.order = order;
        this.root = null;
    }
    
    /**
     * Constructor
     */
    public BTree()
    {
        this.order = 3;
        this.root = null;
    }
    /**
     * private class used as the tree node
     * 
     * @author 
     * @version 1.0
     */
    private class BTreeNode
    {
        /**
         * Attributes
         */
        private BTreeNode fatherNode;
        private ArrayList<BTreeNode> childrenNodes;
        
        private ArrayList<Comparable> elements;
        private int order;
        private int position;
        
        
        public BTreeNode(int order, Comparable element)
        {
            this.order = order;
            this.elements = new ArrayList<Comparable>();
            elements.add(element);
            this.childrenNodes = null;
            this.fatherNode = null;
            this.position = -1;
        }
        
        public BTreeNode(int order)
        {
            this.order = order;
            this.elements = new ArrayList<Comparable>();
            this.childrenNodes = null;
            this.fatherNode = null;
            this.position = -1;
        }
        
        /**
         * Class attribute getter
         * 
         * @return the position
         */
        public int getPosition()
        {
            return this.position;
        }
        
        /**
         * Class attribute setter
         * 
         * @param position the position to set
         */
        public void setPosition(int position)
        {
            this.position = position;
        }
        
        /**
         * Class attribute getter
         * 
         * @return the order
         */
        public int getOrder()
        {
            return this.order;
        }
        
        /**
         * Class attribute setter
         * 
         * @param order the order to set
         */
        public void setOrder(int order)
        {
            this.order = order;
        }
        
        /**
         * Class attribute getter
         * 
         * @return the count
         */
        public int getCount()
        {
            return this.elements.size();
        }
        
        /**
         * Class attribute getter
         * 
         * @return the fatherNode
         */
        public BTreeNode getFatherNode()
        {
            return this.fatherNode;
        }
        
        /**
         * Class attribute setter
         * 
         * @param fatherNode the fatherNode to set
         */
        public void setFatherNode(BTreeNode fatherNode)
        {
            this.fatherNode = fatherNode;
        }
        
        /**
         * Class attribute getter
         * 
         * @return the childrenNodes
         */
        public ArrayList<BTreeNode> getChildrenNodes()
        {
            return this.childrenNodes;
        }
        
        /**
         * Class attribute setter
         * 
         * @param childrenNodes the childrenNodes to set
         */
        public void setChildrenNodes(ArrayList<BTreeNode> childrenNodes)
        {
            this.childrenNodes = childrenNodes;
        }
        
        /**
         * Class attribute getter
         * 
         * @return the elements
         */
        
        public ArrayList<Comparable> getElements()
        {
            return this.elements;
        }
        
        /**
         * Class attribute setter
         * 
         * @param elements the elements to set
         */
        
        public void setElements(ArrayList<Comparable> elements)
        {
            this.elements = elements;
        }
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see bTree.IBTree#add(java.lang.Comparable)
     */
    
    @Override
    public void add(Comparable o)
    {
        Object object = find(o);
        if(object != null)
        {
            return;
        }
        if(this.root == null)// first element
        {
            BTreeNode btn = new BTreeNode(this.order, o);
            this.root = btn;
        }
        else
        // more than one element
        {
            addToLeaf(this.root, o);
        }
    }
    
    
    private void split(BTreeNode btn)// when sub nodes and elements are
    // already properly placed
    {
        BTreeNode fatherNode = btn.getFatherNode();// get its father
        // node
        int pointer = 0;
        BTreeNode leftBranch = new BTreeNode(btn.getOrder());
        BTreeNode rightBranch = new BTreeNode(btn.getOrder());
        while(pointer < btn.getOrder())
        {
            leftBranch.getElements().add(btn.getElements().get(pointer));
            pointer++;
        }
        pointer++;
        while(pointer < btn.getOrder() * 2 + 1)
        {
            rightBranch.getElements().add(btn.getElements().get(pointer));
            pointer++;
        }
        if(btn.getChildrenNodes() != null)// not leaf
        {
            pointer = 0;
            ArrayList<BTreeNode> leftChildren = new ArrayList<BTreeNode>();
            while(pointer <= btn.getOrder())
            {
                BTreeNode child = btn.getChildrenNodes().get(pointer);
                leftChildren.add(child);
                child.setPosition(pointer);
                child.setFatherNode(leftBranch);
                pointer++;
            }
            leftBranch.setChildrenNodes(leftChildren);
            ArrayList<BTreeNode> rightChildren = new ArrayList<BTreeNode>();
            while(pointer <= btn.getOrder() * 2 + 1)
            {
                BTreeNode child = btn.getChildrenNodes().get(pointer);
                rightChildren.add(child);
                child.setPosition(pointer - btn.getOrder() - 1);
                child.setFatherNode(rightBranch);
                pointer++;
            }
            rightBranch.setChildrenNodes(rightChildren);
        }
        if(fatherNode == null)// reached the root
        {
            BTreeNode newNode = new BTreeNode(btn.getOrder());
            newNode.getElements().add(btn.getElements().get(btn.getOrder()));
            ArrayList<BTreeNode> children = new ArrayList<BTreeNode>();
            children.add(leftBranch);
            children.add(rightBranch);
            leftBranch.setFatherNode(newNode);
            rightBranch.setFatherNode(newNode);
            leftBranch.setPosition(0);
            rightBranch.setPosition(1);
            newNode.setChildrenNodes(children);
            this.root = newNode;
        }
        else
        // not the root
        {
            ArrayList<Comparable> currentElements = fatherNode.getElements();
            if(btn.getPosition() == btn.getOrder() * 2)
            {
                currentElements.add(btn.getElements().get(btn.getOrder()));
                fatherNode.getChildrenNodes().remove(btn.getPosition());
                fatherNode.getChildrenNodes().add(leftBranch);
                fatherNode.getChildrenNodes().add(rightBranch);
                leftBranch.setFatherNode(fatherNode);
                rightBranch.setFatherNode(fatherNode);
                for(int i = 0; i < fatherNode.getChildrenNodes().size(); i++)
                {
                    fatherNode.getChildrenNodes().get(i).setPosition(i);
                }
            }
            else
            {
                currentElements.add(btn.getPosition(), btn.getElements().get(
                        btn.getOrder()));
                fatherNode.getChildrenNodes().remove(btn.getPosition());
                fatherNode.getChildrenNodes()
                        .add(btn.getPosition(), leftBranch);
                fatherNode.getChildrenNodes().add(btn.getPosition() + 1,
                        rightBranch);
                leftBranch.setFatherNode(fatherNode);
                rightBranch.setFatherNode(fatherNode);
                for(int i = 0; i < fatherNode.getChildrenNodes().size(); i++)
                {
                    fatherNode.getChildrenNodes().get(i).setPosition(i);
                }
            }
        }
    }
    
    private void checkAndSplit(BTreeNode btn)
    {
        if(btn.getCount() >= btn.getOrder() * 2 + 1)// need to split
        {
            split(btn);
            if(btn.getFatherNode() != null)
            {
                checkAndSplit(btn.getFatherNode());
            }
        }
    }
    
    
    private void addToLeaf(BTreeNode btn, Comparable o)
    {
        if(btn.getElements().contains(o))
        {
            return;
        }
        if(btn.getChildrenNodes() == null)// leaf
        {
            btn.getElements().add(o);
            Collections.sort(btn.getElements());// sort the elements in the
            // leaf
            checkAndSplit(btn);
        }
        else
        // not leaf, add to its proper sub node
        {
            int pointer = 0;
            while(pointer < btn.getElements().size())
            {
                if(o.compareTo(btn.getElements().get(pointer)) < 0)// found it
                {
                    break;
                }
                pointer++;
            }
            addToLeaf(btn.getChildrenNodes().get(pointer), o);
        }
    }
    
    
    private Object findNode(BTreeNode btn, Comparable o)
    {
        int index = -1;
        ArrayList<Comparable> al = btn.getElements();
        for(int i = 0; i < al.size(); i++)
        {
            if(o.compareTo(al.get(i)) == 0)
            {
                index = i;
                break;
            }
        }
        if(index == -1)// can not find it
        {
            if(btn.getChildrenNodes() == null)// leaf
            {
                return null;
            }
            else
            // not leaf, add to its proper sub node
            {
                int pointer = 0;
                while(pointer < btn.getElements().size())
                {
                    if(o.compareTo(btn.getElements().get(pointer)) < 0)// found
                    // it's sub node
                    {
                        break;
                    }
                    pointer++;
                }
                return findNode(btn.getChildrenNodes().get(pointer), o);
            }
        }
        else
        {
            return btn.getElements().get(index);
        }
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see bTree.IBTree#find(java.lang.Comparable)
     */
    
    @Override
    public Object find(Comparable o)
    {
        if(this.root == null)
        {
            return null;
        }
        else
        {
            return findNode(this.root, o);
        }
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see bTree.IBTree#iterator()
     */
    
    @Override
    public Iterator iterator()
    {
        ArrayList<Comparable> al = new ArrayList<Comparable>();
        fill(al, this);
        return al.iterator();
    }
    
    
    private void fill(ArrayList<Comparable> al, BTree bt)
    {
        if(bt.root == null)
        {
            return;
        }
        fill(al, bt.root);
    }
    
    
    private void fill(ArrayList<Comparable> al, BTreeNode btn)
    {
        if(btn.getChildrenNodes() == null)// leaf
        {
            for(int i = 0; i < btn.getElements().size(); i++)
            {
                al.add(btn.getElements().get(i));
            }
        }
        else
        {
            int pointer = 0;
            while(pointer < btn.getElements().size())
            {
                fill(al, btn.getChildrenNodes().get(pointer));
                al.add(btn.getElements().get(pointer));
                pointer++;
            }
            fill(al, btn.getChildrenNodes().get(pointer));
        }
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see bTree.IBTree#remove(java.lang.Comparable)
     */
    
    @Override
    public Object remove(Comparable o)
    {
        if(this.root == null)
        {
            return null;
        }
        Container original = new Container();
        findOriginalNode(this.root, o, original);
        if(original.getBtn() == null)
        {
            return null;
        }
        Object object = original.getBtn().getElements().get(
                original.getPosition());
        if(original.getBtn().getChildrenNodes() == null)// leaf,no need to swap
        {
            deleteOneElementFromTheLeaf(original);
        }
        else
        // not leaf,swap them,then delete the one at leaf
        {
            Container smallest = new Container();
            findSmallestNode(original.getBtn().getChildrenNodes().get(
                    original.getPosition() + 1), smallest);
            // swap them
            Comparable temp = original.getBtn().getElements().get(
                    original.getPosition());
            original.getBtn().getElements()
                    .set(
                            original.getPosition(),
                            smallest.getBtn().getElements().get(
                                    smallest.getPosition()));
            smallest.getBtn().getElements().set(smallest.getPosition(), temp);
            deleteOneElementFromTheLeaf(smallest);
        }
        return object;
    }
    
    
    private void deleteOneElementFromTheLeaf(Container c)
    {
        BTreeNode btn = c.getBtn();
        if(btn.getElements().size() <= btn.getOrder())// less than order+1,
        {
            BTreeNode fatherNode = btn.getFatherNode();
            if(fatherNode == null)// it is also root
            {
                if(btn.getElements().size() == 1)
                {
                    this.root = null;
                }
                else
                {
                    btn.getElements().remove(c.getPosition());
                }
                return;
            }
            else
            {
                if(fatherNode.getElements().size() == 1)// only one element,need
                // grand
                {
                    Comparable add = fatherNode.getElements().get(0);
                    BTreeNode grandNode = fatherNode.getFatherNode();
                    if(grandNode == null)// father node is the root
                    {
                        if(btn.getPosition() == 0)// other side is at position
                        // 1
                        {
                            fatherNode.getChildrenNodes().get(1).setFatherNode(
                                    null);
                            fatherNode.getChildrenNodes().get(1)
                                    .setPosition(-1);
                            this.root = fatherNode.getChildrenNodes().get(1);
                            addToLeaf(this.root, add);
                            btn.getElements().remove(c.getPosition());
                            for(int i = 0; i < btn.getElements().size(); i++)
                            {
                                addToLeaf(this.root, btn.getElements().get(i));
                            }
                        }
                        else
                        // other side is at position 0
                        {
                            fatherNode.getChildrenNodes().get(0).setFatherNode(
                                    null);
                            fatherNode.getChildrenNodes().get(0)
                                    .setPosition(-1);
                            this.root = fatherNode.getChildrenNodes().get(0);
                            addToLeaf(this.root, add);
                            btn.getElements().remove(c.getPosition());
                            for(int i = 0; i < btn.getElements().size(); i++)
                            {
                                addToLeaf(this.root, btn.getElements().get(i));
                            }
                        }
                    }
                    else
                    // father node is not the root
                    {
                        if(btn.getPosition() == 0)// other side is at position
                        // 1
                        {
                            fatherNode.getChildrenNodes().get(1).setFatherNode(
                                    grandNode);
                            fatherNode.getChildrenNodes().get(1).setPosition(
                                    fatherNode.getPosition());
                            grandNode.getChildrenNodes().set(
                                    fatherNode.getPosition(),
                                    fatherNode.getChildrenNodes().get(1));
                            addToLeaf(this.root, add);
                            btn.getElements().remove(c.getPosition());
                            for(int i = 0; i < btn.getElements().size(); i++)
                            {
                                addToLeaf(this.root, btn.getElements().get(i));
                            }
                        }
                        else
                        // other side is at position 0
                        {
                            fatherNode.getChildrenNodes().get(0).setFatherNode(
                                    grandNode);
                            fatherNode.getChildrenNodes().get(0).setPosition(
                                    fatherNode.getPosition());
                            grandNode.getChildrenNodes().set(
                                    fatherNode.getPosition(),
                                    fatherNode.getChildrenNodes().get(0));
                            addToLeaf(this.root, add);
                            btn.getElements().remove(c.getPosition());
                            for(int i = 0; i < btn.getElements().size(); i++)
                            {
                                addToLeaf(this.root, btn.getElements().get(i));
                            }
                        }
                    }
                }
                else
                // don't need grand
                {
                    if(btn.getPosition() == 0)
                    {
                        Comparable add = fatherNode.getElements().get(0);
                        fatherNode.getElements().remove(0);
                        fatherNode.getChildrenNodes().remove(0);
                        addToLeaf(this.root, add);
                        btn.getElements().remove(c.getPosition());
                        for(int i = 0; i < btn.getElements().size(); i++)
                        {
                            addToLeaf(this.root, btn.getElements().get(i));
                        }
                    }
                    else
                    {
                        Comparable add = fatherNode.getElements().get(
                                btn.getPosition() - 1);
                        fatherNode.getElements().remove(btn.getPosition() - 1);
                        fatherNode.getChildrenNodes().remove(btn.getPosition());
                        addToLeaf(this.root, add);
                        btn.getElements().remove(c.getPosition());
                        for(int i = 0; i < btn.getElements().size(); i++)
                        {
                            addToLeaf(this.root, btn.getElements().get(i));
                        }
                    }
                }
            }
        }
        else
        // many elements left,just delete the one
        {
            btn.getElements().remove(c.getPosition());
        }
    }
    
    
    private void findOriginalNode(BTreeNode btn, Comparable o, Container c)
    {
        int index = btn.getElements().indexOf(o);
        if(index == -1)// can not find it
        {
            if(btn.getChildrenNodes() == null)// leaf
            {
                return;
            }
            else
            // not leaf
            {
                int pointer = 0;
                while(pointer < btn.getElements().size())
                {
                    if(o.compareTo(btn.getElements().get(pointer)) < 0)// found
                    // it's sub node
                    {
                        break;
                    }
                    pointer++;
                }
                findOriginalNode(btn.getChildrenNodes().get(pointer), o, c);
            }
        }
        else
        {
            c.setBtn(btn);
            c.setPosition(index);
        }
    }
    
    private void findSmallestNode(BTreeNode btn, Container c)
    {
        if(btn.getChildrenNodes() == null)// leaf
        {
            c.setBtn(btn);
            c.setPosition(0);
        }
        else
        // not leaf
        {
            findSmallestNode(btn.getChildrenNodes().get(0), c);
        }
    }
    /**
     * Because JAVA doesn't support the useful keywords for parameters: in ref
     * out(C#) byval byref (VB.NET), have to make an internal class to do it
     * 
     * @author 
     * @version 1.0
     */
    private class Container
    {
        private BTreeNode btn;
        private int position;
        
        /**
         * Class attribute getter
         * 
         * @return the btn
         */
        public BTreeNode getBtn()
        {
            return this.btn;
        }
        
        /**
         * Class attribute setter
         * 
         * @param btn the btn to set
         */
        public void setBtn(BTreeNode btn)
        {
            this.btn = btn;
        }
        
        /**
         * Class attribute getter
         * 
         * @return the position
         */
        public int getPosition()
        {
            return this.position;
        }
        
        /**
         * Class attribute setter
         * 
         * @param position the position to set
         */
        public void setPosition(int position)
        {
            this.position = position;
        }
    }
    
    /**
     * Class attribute getter
     * 
     * @return the order
     */
    public int getOrder()
    {
        return this.order;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see bTree.IBTree#clear()
     */
    @Override
    public void clear()
    {
        this.root = null;
    }
    
    /*
     * (non-Javadoc)
     * 
     * @see bTree.IBTree#isEmpty()
     */
    @Override
    public boolean isEmpty()
    {
        return this.root == null;
    }
}

