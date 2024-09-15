package com.niantic.collections;

import java.util.*;
import java.util.function.UnaryOperator;

public class GregorsMeebers implements List<String>
{
    private String[] names = "charletta,chin,dureti,elena,eri,hannah,jane,jessy,jordan,karen,robin,roxy,tabatha,valerie".split(",");

    private List<String> team = new ArrayList<>();
    private int maxSize;

    public GregorsMeebers(int maxSize)
    {
        this.maxSize = maxSize;
    }

    @Override
    public int size()
    {
        return team.size();
    }

    @Override
    public boolean isEmpty()
    {
        return team.isEmpty();
    }

    @Override
    public boolean contains(Object o)
    {
        return team.contains(o);
    }

    @Override
    public Iterator<String> iterator()
    {
        return team.iterator();
    }

    @Override
    public Object[] toArray()
    {
        return team.toArray();
    }

    @Override
    public <String> String[] toArray(String[] a)
    {
        return team.toArray(a);
    }

    @Override
    public boolean add(String t)
    {
        var lowerName = t.toLowerCase();
        if(!Arrays.stream(names).toList().contains(lowerName))
        {
            throw new RuntimeException(t + " is not a valid name for a meeber.");
        }

        if(team.contains(t))
        {
            throw new RuntimeException(t + " is already a meeber.");
        }

        if (team.size() < maxSize)
        {
            return team.add(t);
        }

        throw new RuntimeException(t + "could not be added. The meebers are full.");
    }

    @Override
    public boolean remove(Object o)
    {
        return team.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c)
    {
        return new HashSet<>(team).containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends String> c)
    {
        return team.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends String> c)
    {
        return team.addAll(index, c);
    }

    @Override
    public boolean removeAll(Collection<?> c)
    {
        return team.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c)
    {
        return team.retainAll(c);
    }

    @Override
    public void replaceAll(UnaryOperator<String> operator)
    {
        team.replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super String> c)
    {
        team.sort(c);
    }

    @Override
    public void clear()
    {
        team.clear();
    }

    @Override
    public String get(int index)
    {
        return team.get(index);
    }

    @Override
    public String set(int index, String element)
    {
        if(index < team.size())
        {
            return team.set(index, element);
        }
        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + team.size());
    }

    @Override
    public void add(int index, String element)
    {
        if(index < team.size())
        {
            team.add(index, element);
        }
    }

    @Override
    public String remove(int index)
    {
        return team.remove(index);
    }

    @Override
    public int indexOf(Object o)
    {
        return team.indexOf(o);
    }

    @Override
    public int lastIndexOf(Object o)
    {
        return team.lastIndexOf(o);
    }

    @Override
    public ListIterator<String> listIterator()
    {
        return team.listIterator();
    }

    @Override
    public ListIterator<String> listIterator(int index)
    {
        return team.listIterator(index);
    }

    @Override
    public List<String> subList(int fromIndex, int toIndex)
    {
        return team.subList(fromIndex, toIndex);
    }

    @Override
    public Spliterator<String> spliterator()
    {
        return team.spliterator();
    }

    @Override
    public void addFirst(String t)
    {
        team.addFirst(t);
    }

    @Override
    public void addLast(String t)
    {
        team.addLast(t);
    }

    @Override
    public String getFirst()
    {
        return team.getFirst();
    }

    @Override
    public String getLast()
    {
        return team.getLast();
    }

    @Override
    public String removeFirst()
    {
        return team.removeFirst();
    }

    @Override
    public String removeLast()
    {
        return team.removeLast();
    }

    @Override
    public List<String> reversed()
    {
        return team.reversed();
    }
}
