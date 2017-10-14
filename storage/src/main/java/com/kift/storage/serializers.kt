package com.kift.storage

import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 * Created by Eerik on 01/10/17.
 */
class ListParameterizedType(private val type: Type) : ParameterizedType {

    override fun getActualTypeArguments(): Array<Type> = arrayOf(type)

    override fun getRawType(): Type = List::class.java

    override fun getOwnerType(): Type? = null
}