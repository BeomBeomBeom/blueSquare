<template>

<v-data-table
    :headers="headers"
    :items="reservationView"
    :items-per-page="5"
    class="elevation-1"
  ></v-data-table>

</template>

<script>
  const axios = require('axios').default;

  export default {
    name: 'ReservationView',
    props: {
      value: Object,
      editMode: Boolean,
      isNew: Boolean
    },
    data: () => ({
        headers: [
            { text: "id", value: "id" },
        ],
        reservationView : [],
    }),
    async created() {
      var temp = await axios.get(axios.backend + '/reservationViews')

 = temp.data._embedded.reservationViews;

    },
    methods: {
    }
  }
</script>

 = temp.data._embedded.reservationViews;

    },
    methods: {
    }
  }
</script>

