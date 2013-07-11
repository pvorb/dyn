package de.vorb.data.immutable

import scala.collection.immutable.{ Seq, Map }
import scala.language.dynamics

/**
 * Dynamically accessible wrapper for immutable `Seq` and `Map`.
 */
case class Dyn[A](orig: A) extends scala.Dynamic {
  def selectDynamic(key: String) = apply[A](key)
  def selectDynamic[B](key: String) = apply[B](key).orig

  def value[B] = orig.asInstanceOf[B]

  def apply[B](i: Int) = orig match {
    case seq: Seq[_] => Dyn(seq(i).asInstanceOf[B])
    case _           => throw new NoSuchElementException(i.toString)
  }

  def apply[B](key: String) = orig match {
    case map: Map[String, Any] => Dyn(map(key).asInstanceOf[B])
    case _                     => throw new NoSuchElementException(key)
  }

  override def toString = orig.toString
}
