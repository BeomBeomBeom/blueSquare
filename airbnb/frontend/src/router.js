
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import PaymentManager from "./components/PaymentManager"

import HallManager from "./components/HallManager"
import ReviewManager from "./components/ReviewManager"

import ReservationManager from "./components/ReservationManager"

import ReservationView from "./components/ReservationView"
import MessageManager from "./components/MessageManager"

export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/Payment',
                name: 'PaymentManager',
                component: PaymentManager
            },

            {
                path: '/Hall',
                name: 'HallManager',
                component: HallManager
            },
            {
                path: '/Review',
                name: 'ReviewManager',
                component: ReviewManager
            },

            {
                path: '/Reservation',
                name: 'ReservationManager',
                component: ReservationManager
            },

            {
                path: '/ReservationView',
                name: 'ReservationView',
                component: ReservationView
            },
            {
                path: '/Message',
                name: 'MessageManager',
                component: MessageManager
            },



    ]
})
