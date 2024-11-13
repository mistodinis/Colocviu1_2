package ro.pub.cs.systems.eim.lab03.phonedialer.general

import ro.pub.cs.systems.eim.lab03.phonedialer.R

interface Constants {
    companion object {
        val buttonIds: IntArray = intArrayOf(
            R.id.number_0_button,
            R.id.number_1_button,
            R.id.number_2_button,
            R.id.number_3_button,
            R.id.number_4_button,
            R.id.number_5_button,
            R.id.number_6_button,
            R.id.number_7_button,
            R.id.number_8_button,
            R.id.number_9_button,
            R.id.star_button,
            R.id.pound_button
        )
        const val PERMISSION_REQUEST_CALL_PHONE: Int = 1
    }
}
