package com.ten.lifecat.phone.bean

/**
 * Created by 59682 on 2017/10/7.
 */

class Msg {

    var content: String? = null
        private set
    var type: Int = 0
        private set
    private var myTalking: String? = null

    private val talking: String?
        get() {
            val Talking = arrayOf("Constant dropping wears the stone. (滴水穿石。）", "Experience is the mother of wisdom.（经验是智慧之母。）", "Every man is his own worst enemy.(一个人最大的敌人就是他自 己。）", "Saying and doing are two different things. (说和做是迥然不同的两回事。）", "Actions speak louder than words. (行动比语言更响亮。）", "From small beginnings comes great things. (伟大始于渺小。）", "Money spent on the brain is never spent in vain. (智力投资绝不会白花。）", "Wisdom in the mind is better than money in the hand.（脑中有知识，胜过手中有金钱。）", "The voice of one man is the voice of no one. (一个人的声音没有力量。）", "A great ship asks for deep waters.（大船要走深水。）", "While there is life, there is hope.（有生命便有希望/留得青山在,哪怕没柴烧）", "Two heads are better than one. (一人不及二人智;三个臭皮匠,胜个过一个诸葛亮。）", "Wise men learn by other men's mistakes; fools by their own. (聪明人从别人的错误中学得教训；笨人则自己付出代价。他山之石可以攻玉。）", "Good company on the road is the shortest cut. (行路有良伴就是捷径。）", "It takes all sorts to make a world. (世界是由各种不同的人所组成的。）", "If a thing is worth doing it is worth worth doing well. (如果事情值得做，就值得好好做。）")
            val r = (Math.random() * 16).toInt()

            myTalking = Talking[r]

            return myTalking
        }

    constructor(content: String, type: Int) {
        this.content = content
        this.type = type
    }

    constructor(type: Int) {
        this.content = talking
        this.type = type
    }

    companion object {
        val TYPE_RECEIVED = 0
        val TYPE_SENT = 1
    }
}
