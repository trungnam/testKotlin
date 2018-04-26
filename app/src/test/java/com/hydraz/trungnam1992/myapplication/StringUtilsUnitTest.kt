package com.hydraz.trungnam1992.myapplication

import android.text.TextUtils
import org.junit.Before
import org.junit.runner.RunWith
import org.mockito.junit.MockitoJUnitRunner
import org.powermock.core.classloader.annotations.PrepareForTest
import com.hydraz.trungnam1992.myapplication.utils.StringUtils
import junit.framework.Assert
import org.junit.Test
import org.mockito.ArgumentMatchers.*
import org.mockito.Mock
import org.powermock.api.mockito.PowerMockito
import org.powermock.api.mockito.PowerMockito.`when`


/**
 * Created by trungnam1992 on 4/26/18.
 */
@RunWith(MockitoJUnitRunner::class)
@PrepareForTest(TextUtils::class,StringUtils::class)
class StringUtilsUnitTest{
    @Mock
    lateinit var stringutl : StringUtils
    @Before
    fun setUp(){
        stringutl = StringUtils()
        PowerMockito.mockStatic(TextUtils::class.java , StringUtils::class.java )
        `when`(TextUtils.isEmpty(isNull() as CharSequence?)).thenReturn(true)
        `when`(TextUtils.isEmpty(isNotNull() as CharSequence?)).thenReturn(false)
    }


}