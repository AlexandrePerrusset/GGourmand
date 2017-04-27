angular.module('GG', ['ionic', 'ngResource', 'ngSanitize', 'ngMessages'])

.config(function($stateProvider, $urlRouterProvider) {
   moment.locale('fr');

  $stateProvider

  .state('app', {
    url: '/app',
    abstract: true,
    templateUrl: 'templates/menu.html',
    controller: 'AppCtrl'
  })

  .state('app.home', {
    url: '/home',
    views: {
      'menuContent': {
        templateUrl: 'templates/home.html'
      }
    }
  })

  .state('app.login', {
    url: '/login',
    views: {
      'menuContent': {
        templateUrl: 'templates/login.html',
        controller: 'LoginCtrl'
      }
    }
  })

  .state('app.list', {
      url: '/list',
      views: {
        'menuContent': {
          templateUrl: 'templates/list.html',
          controller: 'ListCtrl'
        }
      }
    })

  .state('app.detail', {
    url: '/detail',
    views: {
      'menuContent': {
        templateUrl: 'templates/detail.html',
        controller: 'DetailCtrl'
      }
    }
  })

   .state('app.booking2', {
    url: '/bookings2',
    views: {
      'menuContent': {
        templateUrl: 'templates/booking2.html',
        controller: 'BookingCtrl2'
      }
    }
  })

  .state('app.booking', {
    url: '/bookings',
    views: {
      'menuContent': {
        templateUrl: 'templates/booking.html',
        controller: 'BookingCtrl'
      }
    }
  });

  
  // if none of the above states are matched, use this as the fallback
  $urlRouterProvider.otherwise('/app/home');
})

.run(function($ionicPlatform) {
  $ionicPlatform.ready(function() {
    if(window.cordova && window.cordova.plugins.Keyboard) {
      // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
      // for form inputs)
      cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);

      // Don't remove this line unless you know what you are doing. It stops the viewport
      // from snapping when text inputs are focused. Ionic handles this internally for
      // a much nicer keyboard experience.
      cordova.plugins.Keyboard.disableScroll(true);
    }
    if(window.StatusBar) {
      StatusBar.styleDefault();
    }
  });
})

.controller('AppCtrl', function($scope) {
})

.controller('LoginCtrl', function($scope, userService) {
  $scope.service = userService;
})

.controller('BookingCtrl', function($scope, bookingService, REST_BASE_URL) {
  $scope.service = bookingService;
  $scope.imageBaseUrl = REST_BASE_URL + "/image";
})

.controller('BookingCtrl2', function($scope, bookingService2, REST_BASE_URL) {
  $scope.service = bookingService2;
  $scope.imageBaseUrl = REST_BASE_URL + "/image";
})


// .controller('HomeCtrl', function($scope, REST_BASE_URL, productService) {
//   $scope.imageBaseUrl = REST_BASE_URL + "/image/small";
//   $scope.service = productService;

//   // init produits 'nouveauté' et 'coup de coeur'
//   productService.loadNewProducts();
//   productService.loadHeartProducts();

//   $scope.showProduct = function(productId, products) {
//     productService.products = products;
//     productService.showProduct(productId);
//   };

// })

/* Désactiver le bouton back
var path = $location.path();
 if (path.indexOf('submit') != -1)
   $ionicNavBarDelegate.showBackButton(false);
 else
   $ionicNavBarDelegate.showBackButton(true);
*/

.controller('SearchCtrl', function($scope, $state, eateryService) {
/*  $scope.familyId = -1;*/

  $scope.searchEatery = function() {
    eateryService.searchEatery($scope.query/*,$scope.familyId*/);
  };

})

/*.controller('SearchCtrl', function($scope, $state, eateryService, REST_BASE_URL){
  $scope.imgBaseUrl = REST_BASE_URL + "/image";
  $scope.service = eateryService;
  $scope.showDetails = function(){
    console.log('avant affichage détails...');
    $state.go('detail');
  };
})
*/

.controller('ListCtrl', function($scope, eateryService, REST_BASE_URL) {
  $scope.service = eateryService;
  $scope.imageBaseUrl = REST_BASE_URL + "/image";

  $scope.showEatery = function(eateryId) {
    eateryService.showEatery(eateryId);
  };

})

.controller('DetailCtrl', function($scope, eateryService, REST_BASE_URL) {
  $scope.service = eateryService;
  $scope.imageBaseUrl = REST_BASE_URL + "/image";

  $scope.getFigures = function(figures) {
    return figures.map(function(f) {
            return f.name;
          }).join(", ");
  };
})





//----------------------------------------------------------------------------------------
// Services
//----------------------------------------------------------------------------------------


// Constantes
.constant('REST_BASE_URL', 'http://172.16.2.31:8080/SpringRS')


.factory('getRestUrl', function(REST_BASE_URL) {
  var getRestUrl = function(path) {
    return REST_BASE_URL + path;
  };

  return getRestUrl;
})

// Services REST
.factory('EateryResource', function($resource, REST_BASE_URL) {
  return $resource(
    REST_BASE_URL + '/' + 'eatery/:type/:eateryId',
    {type:'@type'},
    {
      search: {method:'POST', isArray: true}
    }
    );
})


.factory('FamilyResource', function($resource, getRestUrl) {
	return $resource(getRestUrl('/families'), {});
})

.factory('UserResource', function($resource, getRestUrl) {
	return $resource(getRestUrl('/users/:type'), {type:'@type'}, {
		authenticate : {method: 'POST', isArray: false}
	});
})

.factory('BookingResource', function($resource, getRestUrl) {
  return $resource(getRestUrl('/bookings'), {type:'@type'}, {
    reservation : {method: 'POST', isArray: false}
  });
})

.factory('BookingUserResource', function($resource, getRestUrl) {
  return $resource(getRestUrl('/bookings/:type/:customerId'), {type:'@type'}, {
    userReservation : {method: 'POST', isArray: false}
  });
})






// Autres services

/*.factory('eateryService', function(EateryResource, $state) {
  var service = {
    search: function(query) {
      console.log('recherche eatery');
      service.eateries = EateryResource.search({
        type: 'search',
        name: query,
        cityId: -1
      });
    },
    showDetail: function(eateryId) {
      service.selectedEatery = EateryResource.get({eateryId:eateryId}, function(data) {
        service.selectedEatery = data;
        $state.go('detail');
      });
    }
  };
  return service;
})*/



.factory('eateryService', function($state, EateryResource, $ionicPopup) {

  var service = {
    //homeProductId : -1,
    loadNewEateriess : function() {
      EateryResource.getByTag(
        {
          tagId: 2, // nouveautés
          type: 'tag'
        },
        function success(data) {
          service.newEateries = data;
        },
        function error(status) {
          service.error = "ERREUR : " + status;
        }
      );
    },
    loadHeartEateries : function() {
      EateryResource.getByTag(
        {
          tagId: 1, // coups de coeur
          type: 'tag'
        },
        function success(data) {
          service.heartEateries = data;
        },
        function error(status) {
          service.error = "ERREUR : " + status;
        }
      );
    },


    searchEatery : function(query/*, familyId*/) {
      console.log("eateryService.searchEatery : QUERY => " + query);
      EateryResource.search(
        {
          name: query,
         /* familyId: familyId,*/
          type: 'search'
        },
        function success(data) {
          service.eateries = data;

   

          // 1er produit affiché par défaut dans détail
          if (data.length > 0) {
            service.showEatery(data[0].id);
          }else {
            var alertPopup = $ionicPopup.alert({
     /*title: 'Vous n\'êtes pas connecté',*/
     template: 'Aucun résultat ne correspond à cette recherche'
   });
   return;
 }
          

          // navigation
          if ($state.current.name != 'app.list') {
            $state.go('app.list');
          }
        },
        function error(status) {
          service.error = "ERREUR : " + status;
        }
      );
    },
    showEatery : function(eateryId) {
      console.log('eateryService.showEatery : ' + eateryId);
      EateryResource.get(
        {eateryId: eateryId},
        function success(data) {
          // highlight selected
          service.eateries.forEach(function(e) {
            e.selected = data.id == e.id;
          });

          service.selectedEatery = data;

          // navigation
          if ($state.current.name != 'app.list') {
            $state.go('app.list');
          }
        },
        function error(status) {
          service.error = "ERREUR : " + status;
        }
      );

    }

  };

  return service;
})





.factory('userService', function(UserResource) {
  var service = {
    error : {},
    authenticate : function (username, password, form) {
      if (!form.$valid) {
        return;
      }

      UserResource.authenticate(
        {username: username, password: password, type: 'auth'},
        function(data) {
          service.user = data;
          delete service.error.auth;
        },
        function() {
          service.error.auth = "Echec de l'authentification";
        }
      );
    },
    logout : function () {
      delete service.user;
      $state.go('app.home');
    }
  };

  return service;
})

      
    

.factory('bookingService', function($ionicPopup, $state, BookingResource, userService) {
  var service = {
    book : function(eatery){

      
            if (!userService.user) {
console.log('utilisateur null');
   var alertPopup = $ionicPopup.alert({
     /*title: 'Vous n\'êtes pas connecté',*/
     template: 'Veuillez vous connecter pour réserver'
   });
   return;
 }


    /* console.log('eatery : ' + eatery)

      BookingResource.reservation(
        {customerId: userService.user.username, eateryId: eatery.id},
        */
 /*       function(data) {
          service.eaterybook = {
            eatery: eatery,
            user: userService.user
          };
        }
*/

/*
   alertPopup.then(function(res) {
     console.log('Thank you for not eating my delicious ice cream cone');
   });*/

          console.log('data résa ok');
          $state.go('app.booking')
      /*  },*/
       /* function() {
           console.log('data résa KO');
        }*/
      /*);*/
    }   
    
  };

  return service;
})


.factory('bookingService2', function($ionicPopup, $state, BookingResource, userService) {
  var service = {
    book2 : function(eatery, date, nbper, time){





   var bookingDate = moment(date).toObject();
    var bookingTime = moment(time).toObject();



    var bookingDateTime = moment([
      bookingDate.years, bookingDate.months, bookingDate.date,
      bookingTime.hours, bookingTime.minutes, 0
    ]).toDate();



    if (!nbper) {
   var alertPopup = $ionicPopup.alert({
     template: 'Tous les champs ne sont pas renseignés'
   });
   return;
 }



  if (bookingDateTime < moment()) {
   var alertPopup = $ionicPopup.alert({
     template: 'La date/heure n\'est pas renseignée ou inférieur à celle d\'aujourd\'hui'
   });
   return;
 }




console.log('heure saisie' + time)
      BookingResource.reservation(
        {customerId: userService.user.username, eateryId: eatery.id, dateTime: bookingDateTime, numberOfPeople:nbper },
        function(data) {
          service.eaterybook = {
            eatery: eatery,
            user: userService.user,
            dateformated: moment(bookingDateTime).format('DD MMMM YYYY à kk:mm'),
            nbper: nbper
          };





/*
   alertPopup.then(function(res) {
     console.log('Thank you for not eating my delicious ice cream cone');
   });*/

          console.log('data résa ok');
          $state.go('app.booking2')
        },
        function() {
           console.log('data résa KO');
        }
      );
    }   
    
  };

  return service;
});

