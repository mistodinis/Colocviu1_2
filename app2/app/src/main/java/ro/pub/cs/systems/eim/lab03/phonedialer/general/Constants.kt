package ro.pub.cs.systems.eim.lab03.phonedialer.general

import ro.pub.cs.systems.eim.lab03.phonedialer.R

interface Constants {
    companion object {
        val buttonIds: IntArray = intArrayOf(
            R.id.buton,
            R.id.input1,
            R.id.input2,
            R.id.op,
            R.id.result
        )
        const val PERMISSION_REQUEST_CALL_PHONE: Int = 1
    }
}
