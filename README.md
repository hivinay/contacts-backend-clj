# contacts-backend-clj

[![Deploy](https://www.herokucdn.com/deploy/button.png)](https://heroku.com/deploy)

Used for a tech talk at a Michigan Hackers Hack Night event (https://github.com/hivinay/clojure-web-talk/
)

## Usage

Download and run with `lein run`.

## Options

Requires the following environment variables:
* `PORT`
* `DB_HOST`
* `DB_USER`
* `DB_NAME`
* `DB_TABLE`

The Postgres table with the above connection settings must have two text fields called `name` and `email`.

### Bugs

Please feel free to report any bugs.

## License

GPL v3 (http://www.gnu.org/licenses/gpl-3.0.html)
