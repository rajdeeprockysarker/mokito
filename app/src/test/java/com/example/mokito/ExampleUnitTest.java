package com.example.mokito;

import android.app.UiAutomation;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.mockito.stubbing.Answer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class ExampleUnitTest {


    @Rule
    public MockitoRule mockitoRule = MockitoJUnit.rule();

    @Mock
    aDD mADD;

    @Mock
    Student student;

    @Mock
    ArrayList<String> mArrayList;

    @Spy
    ArrayList<String> mStringArrayList;

    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void addmethod(){

        Answer<Integer> ans = new Answer<Integer>() {


            private int count;

            @Override
            public Integer answer(InvocationOnMock invocation) throws Throwable {
                return ++count;
            }
        };

        when(mADD.add(5,6)).thenAnswer(ans);


        mADD.add(5,6);
        verify(mADD,times(1)).add(5,6);
        assertEquals(mADD.add(5,6), 11);
    }




    @Test
    public void thenAns(){

        Answer<Integer> ans = new Answer<Integer>() {


            private int count=0;

            @Override
            public Integer answer(InvocationOnMock invocation) throws Throwable {
                return ++count;
            }
        };

        when(mADD.add(5,6)).thenAnswer(ans);


        mADD.add(5,6);
        mADD.add(5,6);
        verify(mADD,times(2)).add(5,6);
        assertEquals(mADD.add(5,6), 3);
    }




    @Test
    public void resultSPY(){

    /// this Should be 1, but if you mock it, the add() method not ovverrride here.
       /*
        mArrayList.add("one");
        Mockito.verify(mArrayList).add("one");

        assertEquals(1, mArrayList.size());
        */

        /// this Should be 1, because you @SPY it, the add() method ovverrride here.
        mStringArrayList.add("one");
        Mockito.verify(mStringArrayList).add("one");

        assertEquals(1, mStringArrayList.size());



    }

    @Captor
    private ArgumentCaptor<List<String>> captor;

    @Test
    public void argumentmatcher(){
        List<String> asList = Arrays.asList("someElement_test", "someElement");
        final List<String> mockedList = mock(List.class);
        mockedList.addAll(asList);

        verify(mockedList).addAll(captor.capture());
        final List<String> capturedArgument = captor.getValue();
       // assertThat(capturedArgument, hasItem("someElement"));
    }


}