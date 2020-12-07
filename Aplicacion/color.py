import requests
import sys


def colorear(path):
	r = requests.post(
	    "https://api.deepai.org/api/colorizer",
	    files={
	        'image': open(path, 'rb'),
	    },
	    headers={'api-key': 'quickstart-QUdJIGlzIGNvbWluZy4uLi4K'}
	)
	return r.json()['output_url']

print(colorear(sys.argv[1]))
