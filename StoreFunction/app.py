import json
import boto3

def lambda_handler(event, context):
    """Sample pure Lambda function"""

    dynamodb = boto3.resource('dynamodb')
    table = dynamodb.Table("vehicles")
    table.put_item(Item=event)

    return {
        "statusCode": 200,
        "body": json.dumps({
            "message": "Successfully Stored!",
        }),
    }
